package web.app.madhurgupta.challenge.May.Week2;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 10-05-2020 05:17
*/

public class Check_If_It_Is_a_Straight_Line {
    public static void main(String[] args) {
        Check_If_It_Is_a_Straight_Line ob = new Check_If_It_Is_a_Straight_Line();
        System.out.println(ob.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println(ob.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        double slop = slope(coordinates[0], coordinates[1]);
        for (int i = 1; i < coordinates.length; i++) {
            if (slop != slope(coordinates[i], coordinates[0]))
                return false;
        }
        return true;
    }

    public double slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
