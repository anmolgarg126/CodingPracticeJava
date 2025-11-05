package main.java.other;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Get hits for given window
 */
class HitCalculator {
    private static final int WINDOW = 300;
    private static final Deque<Bucket> queue = new ArrayDeque<>();
    private int counter = 0;

    static class Bucket {
        int ts;
        int cnt;

        public Bucket(int ts, int cnt) {
            this.ts = ts;
            this.cnt = cnt;
        }
    }

    public void hit(int ts) {
        evict(ts);
        if (!queue.isEmpty() && queue.getLast().ts == ts) {
            queue.getLast().cnt++;
        } else {
            queue.addLast(new Bucket(ts, 1));
        }
        counter++;
    }

    public int getHits(int ts) {
        evict(ts);
        return counter;
    }

    private void evict(int ts) {
        int cutOff = ts - WINDOW + 1;
        while (!queue.isEmpty() && queue.getFirst().ts < cutOff) {
            counter -= queue.removeFirst().cnt;
        }
    }

    public static void main(String[] args) {
        var obj = new HitCalculator();
        obj.hit(1);
        obj.hit(1);
        obj.hit(2);
        System.out.println(obj.getHits(3));
        obj.hit(301);
        System.out.println(obj.getHits(301));
        System.out.println(obj.getHits(602));

    }
}