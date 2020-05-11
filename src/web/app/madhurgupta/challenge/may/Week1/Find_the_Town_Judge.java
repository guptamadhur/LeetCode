package web.app.madhurgupta.challenge.may.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 12-05-2020 01:03
*/

public class Find_the_Town_Judge {
    public static void main(String[] args) {
        Find_the_Town_Judge ob = new Find_the_Town_Judge();
        System.out.println(ob.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
        System.out.println(ob.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }

    public int findJudge(int N, int[][] trust) {
        int[] outDegree = new int[N + 1];
        int[] inDegree = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            outDegree[trust[i][0]]++;
            inDegree[trust[i][1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == N - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
