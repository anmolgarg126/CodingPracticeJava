package main.java.leetcode;

/*
Question: 11. Container With Most Water
Link: https://leetcode.com/problems/container-with-most-water
 */
public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        var obj = new ContainerWithMostWater_11();
        System.out.println(obj.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(obj.maxArea(new int[]{1, 1}));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
