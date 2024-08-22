package main.java.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: 912. Sort an Array
Link: https://leetcode.com/problems/sort-an-array
Divide and Conquer
Heap (Priority Queue)
Merge Sort
Bucket Sort
Radix Sort
Counting Sort
 */
public class SortAnArray_912 {
    public static void main(String[] args) {
        var obj = new SortAnArray_912();
        System.out.println(Arrays.toString(obj.sortArray(new int[]{1, 5, 3, 2, 4})));
    }


    public int[] sortArray(int[] nums) {
        return heapSort(nums);
    }

    /**
     * TC: O(nlog(n))
     * SC: O(n)
     */
    private int[] heapSort(int[] nums) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int i : nums) {
            heap.add(i);
        }

        // System.out.println(heap);
        int i = 0;
        while (!heap.isEmpty()) {
            nums[i++] = heap.poll();
        }
        return nums;
    }

    /**
     * Also known as divide and conquer
     * TC: O(nlog(n))
     * SC: O(n)
     */
    private int[] mergeSort(int[] nums) {
        Queue<Integer> heap = new PriorityQueue<>();

        for (int i : nums) {
            heap.add(i);
        }

        // System.out.println(heap);
        int i = 0;
        while (!heap.isEmpty()) {
            nums[i++] = heap.poll();
        }
        return nums;
    }

}
