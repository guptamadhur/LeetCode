package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 30-05-2020 21:24
*/

import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array {
    public static void main(String[] args) {
        Contiguous_Array ob = new Contiguous_Array();
        System.out.println(ob.findMaxLength(new int[]{0, 1}));
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                max = Math.max(max, i - map.get(sum));
            }
            if (sum == 0) {
                max = Math.max(max, i + 1);
            }
        }
        return max;
    }
}
