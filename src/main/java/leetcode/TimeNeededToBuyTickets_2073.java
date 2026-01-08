package main.java.leetcode;

/*
Question: 2073. Time Needed to Buy Tickets
Link: https://leetcode.com/problems/time-needed-to-buy-tickets/
 */
public class TimeNeededToBuyTickets_2073 {
    public static void main(String[] args) {
        var obj = new TimeNeededToBuyTickets_2073();
        System.out.println(obj.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int v = tickets[k];
        int result = 0, left = 0, right = tickets.length - 1;
        while (left < k || k < right) {
            if (left < k) {
                result += Math.min(tickets[left], v);
                left++;
            }
            if (right > k) {
                result += Math.min(tickets[right], v - 1);
                right--;
            }
        }
        return result+v;
    }
}
