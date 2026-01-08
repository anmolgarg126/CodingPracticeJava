package main.java.other;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // ---- helpers to recognise tokens ----
    static boolean isURL(String s) {
        return s.startsWith("http://") || s.startsWith("https://");
    }
    static boolean isEmail(String s) {
        int at = s.indexOf('@');
        return at > 0 && at < s.length() - 1;
    }
    static boolean isBulletToken(String s) {
        if (s.equals("*")) return true;
        return s.matches("\\d+\\.");
    }

    // ---- command parsing ----
    static class Cmd {
        int defaultW = 75;
        Integer wEven = null, wOdd = null, wUniform = null;
        boolean hyphen = false;

        int widthForLine(int lineIdx) {
            if (wEven != null || wOdd != null) {
                int even = (wEven != null ? wEven : 75);
                int odd  = (wOdd  != null ? wOdd  : 75);
                return (lineIdx % 2 == 0) ? even : odd;
            }
            if (wUniform != null) return wUniform;
            return defaultW;
        }
    }

    static Cmd parseCommand(String cmdLine) {
        String[] t = cmdLine.trim().split("\\s+");
        Cmd c = new Cmd();
        for (int i = 0; i < t.length; i++) {
            if (t[i].equals("-h")) c.hyphen = true;
            else if (t[i].equals("-w") && i + 1 < t.length) {
                c.wUniform = Integer.parseInt(t[++i]);
            } else if (t[i].equals("-wE") && i + 1 < t.length) {
                c.wEven = Integer.parseInt(t[++i]);
            } else if (t[i].equals("-wO") && i + 1 < t.length) {
                c.wOdd = Integer.parseInt(t[++i]);
            }
        }
        return c;
    }

    // ---- formatter core ----
    static List<String> format(List<String> paragraphs, Cmd cmd) {
        List<String> out = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        int lineIdx = 0;
        boolean lastWasBlank = false;

        // append current line to output (trim trailing space)
        Runnable flushLine = () -> {
            if (line.length() > 0) {
                // trim trailing space if any
                int len = line.length();
                while (len > 0 && line.charAt(len - 1) == ' ') len--;
                out.add(line.substring(0, len));
                line.setLength(0);
            }
        };
        // ensure paragraph break (single blank line)
        Runnable newParagraph = () -> {
            flushLine.run();
            if (!out.isEmpty() && !out.get(out.size() - 1).isEmpty()) {
                out.add(""); // one blank line between paragraphs
            } else if (out.isEmpty()) {
                // no preceding text, do nothing extra
            }
        };

        Pattern splitter = Pattern.compile("\\s+");

        for (String para : paragraphs) {
            if (para == null) { // paragraph break sentinel
                newParagraph.run();
                lastWasBlank = true;
                continue;
            }
            // normal paragraph
            lastWasBlank = false;
            String[] rawTokens = splitter.split(para.trim(), -1);
            List<String> tokens = new ArrayList<>();
            for (String tok : rawTokens) {
                if (tok.isEmpty()) continue;
                tokens.add(tok);
            }

            // walk tokens, respecting bullets
            int i = 0;
            String pendingBullet = null;

            while (i < tokens.size()) {
                String tok = tokens.get(i);

                if (isBulletToken(tok)) {
                    // start a new line for bullet
                    flushLine.run();
                    pendingBullet = tok + " ";
                    // place bullet prefix immediately
                    line.append(pendingBullet);
                    pendingBullet = null; // only once
                    i++;
                    continue;
                }

                // normal word / url / email
                boolean unbreakable = isURL(tok) || isEmail(tok);

                // try to place token (with space if needed)
                placeToken(tok, unbreakable, cmd, out, line);
                while (tok.length() > 0 && line == null) {
                    // not used; kept for clarity
                }
                // If token didn’t fit and line was empty and token is URL/email longer than width,
                // place as is (overflow permitted on empty line)
                if (unbreakable) {
                    // handled inside placeToken
                } else {
                    // handled incl. hyphenation inside placeToken
                }

                i++;
            }
            // paragraph ends -> break
            newParagraph.run();
        }

        // remove extra blank line at end if any
        if (!out.isEmpty() && out.get(out.size() - 1).isEmpty()) {
            out.remove(out.size() - 1);
        }
        return out;
    }

    // place a token according to rules (including hyphenation)
    static void placeToken(String tok, boolean unbreakable, Cmd cmd,
                           List<String> out, StringBuilder line) {
        int pos = 0;
        while (pos < tok.length()) {
            int width = cmd.widthForLine(out.size() + (line.length() > 0 ? 0 : 0));
            int curLen = line.length();
            int space = (curLen == 0 ? 0 : 1);
            int remaining = width - curLen - space;

            if (remaining < 0) { // no room even for a space; flush
                // trim and flush
                int len = line.length();
                while (len > 0 && line.charAt(len - 1) == ' ') len--;
                out.add(line.substring(0, len));
                line.setLength(0);
                continue;
            }

            String rest = tok.substring(pos);
            if (unbreakable) {
                if (rest.length() <= remaining) {
                    if (space == 1) line.append(' ');
                    line.append(rest);
                    pos = tok.length();
                } else {
                    // move to next line; if next line is empty we may overflow width
                    if (line.length() > 0) {
                        // flush current line, try again at next line
                        int len = line.length();
                        while (len > 0 && line.charAt(len - 1) == ' ') len--;
                        out.add(line.substring(0, len));
                        line.setLength(0);
                    } else {
                        // empty line -> place whole (overflow allowed)
                        line.append(rest);
                        pos = tok.length();
                        // flush (line completed by single long token)
                        int len = line.length();
                        while (len > 0 && line.charAt(len - 1) == ' ') len--;
                        out.add(line.substring(0, len));
                        line.setLength(0);
                    }
                }
            } else {
                // breakable word
                if (rest.length() <= remaining) {
                    if (space == 1) line.append(' ');
                    line.append(rest);
                    pos = tok.length();
                } else {
                    if (!cmd.hyphen) {
                        // no hyphenation: if anything on line, flush; else move word whole to next line
                        if (line.length() > 0) {
                            int len = line.length();
                            while (len > 0 && line.charAt(len - 1) == ' ') len--;
                            out.add(line.substring(0, len));
                            line.setLength(0);
                        } else {
                            // move whole word to new line (it fits because rules say words <= 75 unless URL/email)
                            line.append(rest);
                            pos = tok.length();
                        }
                    } else {
                        // hyphenation ON: we must fill current line as much as possible,
                        // leaving 1 char for hyphen when splitting within a word.
                        if (remaining <= 0) {
                            // start a new line
                            int len = line.length();
                            while (len > 0 && line.charAt(len - 1) == ' ') len--;
                            out.add(line.substring(0, len));
                            line.setLength(0);
                            continue;
                        }
                        // If we are going to split, we need at least 1 char for hyphen
                        if (rest.length() > remaining) {
                            if (remaining == 1) {
                                // not enough for a letter + hyphen; start a new line
                                int len = line.length();
                                while (len > 0 && line.charAt(len - 1) == ' ') len--;
                                out.add(line.substring(0, len));
                                line.setLength(0);
                                continue;
                            }
                            int take = remaining - 1; // chars from word
                            if (space == 1) line.append(' ');
                            line.append(rest, 0, take);
                            line.append('-');
                            pos += take;
                            // flush the hyphenated line
                            int len = line.length();
                            while (len > 0 && line.charAt(len - 1) == ' ') len--;
                            out.add(line.substring(0, len));
                            line.setLength(0);
                        } else {
                            // it fits now
                            if (space == 1) line.append(' ');
                            line.append(rest);
                            pos = tok.length();
                        }
                    }
                }
            }
        }
    }

    // Split raw input into paragraphs; blank lines -> null sentinel
    static List<String> readParagraphs(BufferedReader br, int N) throws IOException {
        List<String> paras = new ArrayList<>();
        StringBuilder acc = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s == null) s = "";
            if (s.trim().isEmpty()) {
                if (acc.length() > 0) {
                    paras.add(acc.toString());
                    acc.setLength(0);
                }
                // paragraph break sentinel; collapse consecutive breaks by checking last
                if (paras.isEmpty() || paras.get(paras.size() - 1) != null)
                    paras.add(null);
            } else {
                if (acc.length() > 0) acc.append(' ');
                acc.append(s.trim());
            }
        }
        if (acc.length() > 0) paras.add(acc.toString());
        // remove trailing paragraph break sentinel if any
        while (!paras.isEmpty() && paras.get(paras.size() - 1) == null) paras.remove(paras.size() - 1);
        return paras;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        if (first == null || first.trim().isEmpty()) return;
        int N = Integer.parseInt(first.trim());

        // Read N lines of text block
        List<String> paragraphs = readParagraphs(br, N);

        // Command line
        String cmdLine = br.readLine();
        Cmd cmd = parseCommand(cmdLine);

        List<String> out = format(paragraphs, cmd);

        // Print
        for (int i = 0; i < out.size(); i++) {
            System.out.println(out.get(i));
        }
    }
}