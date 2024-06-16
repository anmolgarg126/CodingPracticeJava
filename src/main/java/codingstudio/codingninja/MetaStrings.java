package main.java.codingstudio.codingninja;

/*
Question: Meta Strings
Link:

 */
public class MetaStrings {
    public static void main(String[] args) {
        System.out.println(checkMeta("Coding", "Codnig"));
        System.out.println(checkMeta("Ninjas", "Niaxns"));
        System.out.println(checkMeta("Hello", "Hello"));
        System.out.println(checkMeta("Play", "Playes"));
        System.out.println(checkMeta("Seek", "Seke"));
    }

    public static boolean checkMeta(String str1, String str2) {
        // Write your code here.
        if (str1.length() != str2.length() || str1.equals(str2)) {
            return false;
        }

        int prev = -1, curr = -1;
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;

                if (count > 2) {
                    return false;
                }
                prev = curr;
                curr = i;
            }

        }

        return count == 2 && str1.charAt(prev) == str2.charAt(curr) && str1.charAt(curr) == str2.charAt(prev);
    }
}
