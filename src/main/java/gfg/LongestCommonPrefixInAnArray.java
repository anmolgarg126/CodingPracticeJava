package main.java.gfg;

/*
Question: Longest Common Prefix in an Array
Link: https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129
 */
public class LongestCommonPrefixInAnArray {
    public static void main(String[] args) {
        var obj = new LongestCommonPrefixInAnArray();
        System.out.println(obj.longestCommonPrefix(new String[]{"geeksforgeeks", "geeks", "geek", "geezer"}, 4));
    }

    String longestCommonPrefix(String arr[], int n) {
        // code here
        String min = arr[0];
        String max = arr[0];

        for (String s : arr) {
            if (s.compareTo(min) <= -1) {
                min = s;
            } else if (s.compareTo(max) >= 1) {
                max = s;
            }
        }

        for (int i = 0; i < min.length(); i++) {
            if (min.charAt(i) != max.charAt(i)) {
                if (i == 0) {
                    return "-1";
                } else {
                    return min.substring(0, i);
                }
            }
        }
        return min;
    }
}
