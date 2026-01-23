package main.java.leetcode;

/*
Question: 443. String Compression
Link: https://leetcode.com/problems/string-compression/
 */
public class StringCompression_443 {
    public static void main(String[] args) {
        var obj = new StringCompression_443();
        System.out.println(obj.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(obj.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(obj.compress(new char[]{'a'}));
    }

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char prev = chars[i];
            int j = i + 1;
            while (j < chars.length && prev == chars[j]) {
                j++;
            }
            int freq = j - i;
            if (freq == 1) {
                sb.append(prev);
            } else {
                sb.append(prev).append(freq);
            }
            i = j - 1;
        }
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
