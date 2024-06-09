package gfg;

import java.util.*;

public class MaximizeSumAfterKNegations {
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
//        System.out.println(maximizeSum(new long[]{-1, -2, -3, -4, -5}, 5, 10));
//        System.out.println(catchThieves(new char[]{'P', 'T', 'T', 'P', 'T'}, 5, 1));
//        System.out.println(max_of_subarrays(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 8, 5));
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }

    private static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        if (groupSize == 1) {
            return true;
        }

        Arrays.sort(hand);

        int l = 0, r = 1;

        while (r < n) {
            if (r % groupSize == 0) {
                l = r;
                r++;
            } else if (hand[l] + 1 != hand[r]) {
                return false;
            } else {
                l++;
                r++;
            }
        }
        return true;
    }

    public static long maximizeSum(long a[], int n, int k) {
        // Your code goes here
        // Arrays.sort(a);

        Queue<Long> pq = new PriorityQueue<>();

        for (long i : a) {
            pq.add(i);
        }


        while (k > 0) {
            if (pq.peek() < 0) {
                long temp = pq.poll();
                pq.add(-temp);
                k--;
            } else {
                break;
            }
        }

        if (k % 2 != 0) {
            long temp = pq.poll();
            pq.add(-temp);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>(n - k + 1);
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int l = 0, r = 0;
        while (r < n) {
            pq.add(arr[r]);
            if (r - l + 1 == k) {
                int temp = pq.peek();
                if (arr[l] == temp) {
                    pq.poll();
                }
                res.add(temp);
                l++;
            }
            r++;
        }
        return res;
    }


    static int catchThieves(char arr[], int n, int k) {
        // Code here
        Queue<Temp> queue = new LinkedList<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            if (queue.isEmpty()) {
                queue.add(new Temp(i, arr[i]));
            } else {
                char curr = arr[i] == 'P' ? 'T' : 'P';
                while (!queue.isEmpty() && queue.peek().c == curr) {
                    Temp t = queue.poll();
                    if (i - t.index <= k) {
                        result++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    queue.add(new Temp(i, arr[i]));
                }
            }

        }
        return result;
    }

    static class Temp {
        int index;
        char c;

        public Temp(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }
}
