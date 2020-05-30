package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 30-05-2020 23:21
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Possible_Bipartition {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;

    public static void main(String[] args) {
        Possible_Bipartition ob = new Possible_Bipartition();
        int[][] A = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        System.out.println(ob.possibleBipartition(5, A));
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        color = new HashMap();
        for (int node = 1; node <= N; ++node)
            if (!color.containsKey(node) && !dfs(node, 0))
                return false;
        return true;
    }

    public boolean dfs(int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);

        for (int nei : graph[node])
            if (!dfs(nei, c ^ 1))
                return false;
        return true;
    }
}