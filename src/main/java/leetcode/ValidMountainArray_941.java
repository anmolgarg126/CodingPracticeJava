package main.java.leetcode;

/*
Question: 941. Valid Mountain Array
Link: https://leetcode.com/problems/valid-mountain-array/
 */
public class ValidMountainArray_941 {
    public static void main(String[] args) {
        var obj = new ValidMountainArray_941();
        System.out.println(obj.validMountainArray(new int[]{2, 1}));
        System.out.println(obj.validMountainArray(new int[]{3, 5, 5}));
        System.out.println(obj.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(obj.validMountainArray(new int[]{1, 3, 2}));
    }

    /*
    Two people climb from left and from right separately.
    If they are climbing the same mountain, they will meet at the same point.
     */
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, i = 0, j = n - 1;
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        while (j > 0 && arr[j - 1] > arr[j]) {
            j--;
        }
        return i == j && i > 0 && j < n - 1;
    }
}
