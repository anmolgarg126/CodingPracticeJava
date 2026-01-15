package main.java.leetcode;

/*
Question: 686. Repeated String Match
Link: https://leetcode.com/problems/repeated-string-match/
 */
public class RepeatedStringMatch_686 {
    public static void main(String[] args) {
        var obj = new RepeatedStringMatch_686();
        System.out.println(obj.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(obj.repeatedStringMatch("a", "aa"));
        System.out.println(obj.repeatedStringMatch("abc", "wxyz"));
        System.out.println(obj.repeatedStringMatch("abcd", "cdabcdab"));
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder aBuilder = new StringBuilder(a);
        int res = 1;
        while (aBuilder.length() < b.length()) {
            aBuilder.append(a);
            res++;
        }
        if (aBuilder.toString().contains(b)) {
            return res;
        }
        aBuilder.append(a);
        res++;
        if (aBuilder.toString().contains(b)) {
            return res;
        }
        return -1;
    }
}
