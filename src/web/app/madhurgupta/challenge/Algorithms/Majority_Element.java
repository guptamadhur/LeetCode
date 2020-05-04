package web.app.madhurgupta.challenge.Algorithms;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 05-05-2020 03:45
*/

/*
    Input: [2,2,1,1,1,2,2]
    Output: 2
*/

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Majority_Element {
    public static void main(String[] args) {
        Majority_Element ob = new Majority_Element();
        int[] list = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(ob.majorityElement(list));
    }

    public int majorityElement(int[] nums) {
        int nmax = nums.length / 2, res = 0;
        Map<Integer, Long> freq = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Integer, Long> val : freq.entrySet()) {
            long v = val.getValue();
            if (v > nmax) {
                res = val.getKey();
                nmax = (int) v;
            }
        }
        return res;
    }
}
