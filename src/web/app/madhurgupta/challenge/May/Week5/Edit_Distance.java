package web.app.madhurgupta.challenge.May.Week5;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 31-05-2020 14:33
*/

public class Edit_Distance {
    public static void main(String[] args) {
        Edit_Distance ob = new Edit_Distance();
        System.out.println(ob.minDistance("intention", "execution"));
    }

    int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    public int minDistance(String word1, String word2) {
        int maxW1 = word1.length(), maxW2 = word2.length(), res = 0;
        // Create a table to store results of subproblems
        int[][] dp = new int[maxW1 + 1][maxW2 + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= maxW1; i++) {
            for (int j = 0; j <= maxW2; j++) {
                // If first string is empty, only option is to insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is to remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char and recur for remaining string
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different, consider all
                    // possibilities and find the minimum
                else
                    dp[i][j] = 1 + min(dp[i][j - 1], // Insert
                            dp[i - 1][j], // Remove
                            dp[i - 1][j - 1]); // Replace
            }
        }
        return dp[maxW1][maxW2];
    }
}