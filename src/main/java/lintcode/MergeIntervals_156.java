package main.java.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_156 {

    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.isEmpty()) {
            return intervals;
        }
        intervals.sort((a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        Interval lastInterval = null;
        for (Interval interval : intervals) {
            if (lastInterval == null || lastInterval.end < interval.start) {
                result.add(interval);
                lastInterval = interval;
            } else {
                lastInterval.end = Math.max(lastInterval.end, interval.end);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        var obj = new MergeIntervals_156();
        List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18));
        System.out.println(obj.merge(intervals));
    }
}
