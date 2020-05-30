package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 26-05-2020 01:31
*/

public class Uncrossed_Lines {
    public static void main(String[] args) {
        Uncrossed_Lines ob = new Uncrossed_Lines();
        System.out.println(ob.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = A[i - 1] == B[j - 1] ? 1 + dp[i - 1][j - 1] : Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
