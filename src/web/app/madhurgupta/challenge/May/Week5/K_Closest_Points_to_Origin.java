package web.app.madhurgupta.challenge.May.Week5;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 31-05-2020 00:54
*/

import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        K_Closest_Points_to_Origin ob = new K_Closest_Points_to_Origin();
        int[][] A = ob.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        for (int[] a : A) {
            System.out.print("[" + a[0] + "," + a[1] + "] ");
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int dist_a = (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2));
            int dist_b = (int) (Math.pow(b[0], 2) + Math.pow(b[1], 2));
            return dist_a - dist_b;
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(new int[]{points[i][0], points[i][1]});
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] a = pq.poll();
            res[i][0] = a[0];
            res[i][1] = a[1];
        }
        return res;
    }
}
