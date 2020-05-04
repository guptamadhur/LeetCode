package web.app.madhurgupta.challenge.Algorithms;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 05-05-2020 03:12
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Majority_Element_II {
    public static void main(String[] args) {
        Majority_Element_II ob = new Majority_Element_II();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        for (int a : ob.majorityElement(nums))
            System.out.print(a + " ");
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Long> freq = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int nk = nums.length / 3;
        for (Map.Entry<Integer, Long> val : freq.entrySet()) {
            long v = val.getValue();
            if (v > nk) {
                list.add(val.getKey());
            }
        }
        return list;
    }
}
