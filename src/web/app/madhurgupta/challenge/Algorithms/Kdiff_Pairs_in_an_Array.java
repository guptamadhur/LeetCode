package web.app.madhurgupta.challenge.Algorithms;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode Java
# Created on: 28-09-2020 13:14
*/

/*
    Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/
    Input:[1, 2, 3, 4, 5], k = 1
    Output: 4
    Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

    Input: [3, 1, 4, 1, 5], k = 2
    Output: 2
    Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    Although we have two 1s in the input, we should only return the number of unique pairs.
*/

import java.util.HashMap;
import java.util.Map;

public class Kdiff_Pairs_in_an_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 1;
        System.out.println(new Kdiff_Pairs_in_an_Array().findPairs(arr, k));
        System.out.println(new Kdiff_Pairs_in_an_Array().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
