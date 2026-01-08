package main.java.leetcode;

/*
Question: 461. Hamming Distance
Link: https://leetcode.com/problems/hamming-distance
 */
public class HammingDistance_461 {
    public static void main(String[] args) {
        var obj = new HammingDistance_461();
        System.out.println(obj.hammingDistance(1, 4));
        System.out.println(obj.hammingDistance(3, 1));
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y; // set the bit to 1 where bits are different
        int result = 0;
        while (z > 0) {
            result += (z & 1);
            z = z >> 1;
        }
        return result;
    }
}
