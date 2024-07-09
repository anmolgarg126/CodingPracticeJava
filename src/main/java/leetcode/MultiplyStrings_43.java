package main.java.leetcode;

/*
Question: 43. Multiply Strings
Link: https://leetcode.com/problems/multiply-strings
 */
public class MultiplyStrings_43 {

    /*
    Consider "123" and "456"
    Multiply "6"(of 456) with "3"(of 123) and keep track of this total sum, for next "6"(of 456) with "2"(of 123),
    but here we need to multiply the product by 10^1 as we do need to account for "2"(123) being in tens place,
    and similarly we do it for everything and keep adding the sum.
    See, pic in MultiplyStrings_43.png
     */
    public static void main(String[] args) {
        var obj = new MultiplyStrings_43();
        System.out.println(obj.multiply("123", "456"));
        System.out.println(obj.multiply("6236467389813890", "6236467389813890657823674689349"));
        System.out.println(obj.multiply("2", "3"));
        System.out.println(obj.multiply("0", "0"));
    }

    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = 0; i < len1; i++) {
            int n1 = num1.charAt(i) - '0';
            for (int j = 0; j < len2; j++) {
                int n2 = num2.charAt(j) - '0';
                int first = len1 - i - 1;
                int second = len2 - j - 1;
                res[first + second] += (n1 * n2);
            }
        }
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < res.length; i++) {
            int curr = res[i] + carry;
            carry = curr / 10;
            sb.append(curr % 10);
        }
        sb.reverse();
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        return index == sb.length() ? "0" : sb.substring(index);
    }
}
