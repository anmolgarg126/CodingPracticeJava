package main.java.leetcode;

/*
Question: 944. Delete Columns to Make Sorted
Link: https://leetcode.com/problems/delete-columns-to-make-sorted
 */
public class DeleteColumnsToMakeSorted_944 {
    public static void main(String[] args) {
        var obj = new DeleteColumnsToMakeSorted_944();
        System.out.println(obj.minDeletionSize(new String[]{"abc", "bce", "cae"}));
        System.out.println(obj.minDeletionSize(new String[]{"a", "b"}));
        System.out.println(obj.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        System.out.println(obj.minDeletionSize(new String[]{"cbi","daf","gha"}));
    }

    public int minDeletionSize(String[] strs) {
        int res = 0;
        char prev = 'A';
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == 0) {
                    prev = strs[j].charAt(i);
                } else if (strs[j].charAt(i) < prev) {
                    res++;
                    break;
                } else {
                    prev = strs[j].charAt(i);
                }
            }
        }
        return res;
    }
}
