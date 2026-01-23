package main.java.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Question: 215. Kth Largest Element in an Array
Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray_215 {
    public static void main(String[] args) {
        var obj = new KthLargestElementInAnArray_215();
        System.out.println(obj.findKthLargest(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(obj.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            while (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
