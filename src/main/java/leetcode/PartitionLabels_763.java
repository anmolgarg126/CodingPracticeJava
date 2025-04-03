package main.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Questions: 763. Partition Labels
Link: https://leetcode.com/problems/partition-labels/description/
 */
public class PartitionLabels_763 {
    public static void main(String[] args) {
        var obj = new PartitionLabels_763();
        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(obj.partitionLabels("eccbbbbdec"));
    }


    public List<Integer> partitionLabels(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }


        List<Integer> partitionSizes = new ArrayList<>();

        int partitionEnd = 0, partitionStart = 0;
        for (int i = 0; i < s.length(); ++i) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i) - 'a']);

            if (i == partitionEnd) {
                partitionSizes.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return partitionSizes;
    }
}
