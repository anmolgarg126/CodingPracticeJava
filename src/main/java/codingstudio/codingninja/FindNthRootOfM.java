package main.java.codingstudio.codingninja;

/*
Question:  Find Nth Root Of M
Link: https://www.naukri.com/code360/problems/nth-root-of-m_1062679
 */
public class FindNthRootOfM {
    public static void main(String[] args) {
        System.out.println(NthRoot(3, 27));
        System.out.println(NthRoot(9, 1953125));
    }

    public static int NthRoot(int n, int m) {
        // Write your code here.
        int l = 0, r = m;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;

            double pow = Math.pow(mid, n);

            if (pow == m) {
                return mid;
            } else if (pow < m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
