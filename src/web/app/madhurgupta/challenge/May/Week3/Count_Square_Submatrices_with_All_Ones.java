package web.app.madhurgupta.challenge.May.Week3;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 22-05-2020 00:58
*/

public class Count_Square_Submatrices_with_All_Ones {
    public static void main(String[] args) {
        Count_Square_Submatrices_with_All_Ones ob = new Count_Square_Submatrices_with_All_Ones();
        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(ob.countSquares(matrix)); //15
    }

    private int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = (matrix[i][j] == 1 ? Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1 : 0);
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
