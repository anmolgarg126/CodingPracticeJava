package main.java.codingstudio.codingninja;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithDistinctIntegers {
    public static void main(String[] args) {
        System.out.println(goodSubarrays(new int[]{1, 2, 1, 2, 3}, 5, 2));
    }

    public static int goodSubarrays(int[] arr, int n, int b) {
        int atmostKDigits = subarraysWithAtmostKDistinct(arr, b);
        int atmostKMinusOneDigits = subarraysWithAtmostKDistinct(arr, b - 1);
        return atmostKDigits - atmostKMinusOneDigits;
    }

    private static int subarraysWithAtmostKDistinct(int arr[], int k) {
        if(k==0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int l=0, r=0, res=0;

        while(r<arr.length) {
            map.merge(arr[r], 1, Integer::sum);

            while(map.size()>k) {
                int temp = map.get(arr[l]);
                if(temp==1) {
                    map.remove(arr[l]);
                }else{
                    map.put(arr[l], temp-1);
                }
                l++;
            }
            res += r-l+1;
            r++;
        }
        return res;
    }
}
