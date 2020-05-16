package web.app.madhurgupta.challenge.Algorithms;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 16-05-2020 22:07
*/

//Max Contiguous Subarray Sum - Cubic Time To Kadane's Algorithm (Maximum Subarray)

public class Maximum_Subarray {
    public static void main(String[] args) {
        Maximum_Subarray ob = new Maximum_Subarray();
        System.out.println(ob.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));//6
    }

    public int maxSubArray(int[] A) {
        int maxv = 0;
        int[] max = new int[A.length];
        max[0] = A[0];
        maxv = max[0];
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max((max[i - 1] + A[i]), A[i]);
            if (max[i] >= maxv) {
                maxv = max[i];
            }
        }
        return maxv;
    }
}
