package main.java.leetcode;

/*
Question: 955. Delete Columns to Make Sorted II
Link: https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class DeleteColumnsToMakeSortedII_955 {
    public static void main(String[] args) {
        var obj = new DeleteColumnsToMakeSortedII_955();
//        System.out.println(obj.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
//        System.out.println(obj.minDeletionSize(new String[]{"xc", "yb", "za"}));
//        System.out.println(obj.minDeletionSize(new String[]{"ca", "bb", "ac"}));
        System.out.println(obj.minDeletionSize(new String[]{"xga","xfb","yfa"}));
    }

    public int minDeletionSize(String[] strs) {
        int res = 0;
        char prev = 'A';
        for (int i = 0; i < strs[0].length(); i++) {
            boolean inOrder = true;
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    prev = strs[j].charAt(i);
                } else if (strs[j].charAt(i) == prev) {
                    inOrder = false;
                } else if (strs[j].charAt(i) < prev) {
                    res++;
                    inOrder = false;
                    break;
                } else {
                    prev = strs[j].charAt(i);
                }
            }
            if (inOrder) {
                return res;
            }
        }
        return res;
    }
}
