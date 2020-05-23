package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 24-05-2020 00:53
*/

public class Interval_List_Intersections1 {
    public static void main(String[] args) {
        Interval_List_Intersections1 ob = new Interval_List_Intersections1();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}}, C = {};
        C = ob.intervalIntersection(A, B); //[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        for (int[] a : C) {
            System.out.print("[" + a[0] + "," + a[1] + "]" + "  ");
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int Alen = A.length, Blen = B.length, nextMatch = 0, j = 0;
        int[][] res = new int[Alen + Blen][2];
        if (Alen != Blen) return res;
        for (int i = 0; i < Alen; i++) {
            if (j > 0 && (nextMatch == B[i][0] || nextMatch == A[i][0])) {
                res[j][0] = nextMatch;
                res[j][1] = nextMatch;
                j++;
            }
            if (B[i][0] >= A[i][0] && B[i][0] <= A[i][1]) {
                res[j][0] = B[i][0];
            } else {
                res[j][0] = A[i][0];
            }
            if (B[i][1] >= A[i][0] && B[i][1] <= A[i][1]) {
                res[j][1] = B[i][1];
                nextMatch = A[i][1];
            } else {
                res[j][1] = A[i][1];
                nextMatch = B[i][1];
            }
            j++;
        }
        return res;
    }
}
