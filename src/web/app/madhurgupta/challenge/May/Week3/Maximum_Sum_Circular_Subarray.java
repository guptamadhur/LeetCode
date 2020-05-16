package web.app.madhurgupta.challenge.May.Week3;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 16-05-2020 14:34
*/

public class Maximum_Sum_Circular_Subarray {
    public static void main(String[] args) {
        Maximum_Sum_Circular_Subarray ob = new Maximum_Sum_Circular_Subarray();
        System.out.println(ob.maxSubarraySumCircular(new int[]{1, -2, 3, -2})); //3
        System.out.println(ob.maxSubarraySumCircular(new int[]{5, -3, 5})); //10
        System.out.println(ob.maxSubarraySumCircular(new int[]{3, -1, 2, -1})); //4
        System.out.println(ob.maxSubarraySumCircular(new int[]{3, -2, 2, -3})); //3
        System.out.println(ob.maxSubarraySumCircular(new int[]{-3, -2, -1})); //-1
        System.out.println(ob.maxSubarraySumCircular(new int[]{1, -2, 3, -2})); //3
        System.out.println(ob.maxSubarraySumCircular(new int[]{2, -2, 2, 7, 8, 0})); //19
        System.out.println(ob.maxSubarraySumCircular(new int[]{9, -4, -7, 9})); //18
    }

    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, cur1 = 0, cur2 = 0, total = 0;
        for (int i = 0; i < A.length; i++) {
            cur1 += A[i];
            max = Math.max(max, cur1);
            cur1 = Math.max(cur1, 0);

            cur2 += A[i];
            min = Math.min(min, cur2);
            cur2 = Math.min(cur2, 0);

            total += A[i];
        }
        return max < 0 ? max : Math.max(max, total - min);
    }
}
