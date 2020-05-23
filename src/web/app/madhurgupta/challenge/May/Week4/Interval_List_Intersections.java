package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 24-05-2020 00:53
*/

import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections {
    public static void main(String[] args) {
        Interval_List_Intersections ob = new Interval_List_Intersections();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}}, C = {};
        C = ob.intervalIntersection(A, B); //[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        for (int[] a : C) {
            System.out.print("[" + a[0] + "," + a[1] + "]" + "  ");
        }
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int Alen = A.length, Blen = B.length, i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < Alen && j < Blen) {
            int maxStart = Math.max(A[i][0], B[j][0]);
            int minEnd = Math.min(A[i][1], B[j][1]);
            if (maxStart <= minEnd) {
                list.add(new int[]{maxStart, minEnd});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[list.size()][2];
        i = 0;
        for (int[] a : list) {
            res[i++] = a;
        }
        return res;
    }
}