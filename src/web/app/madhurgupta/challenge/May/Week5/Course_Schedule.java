package web.app.madhurgupta.challenge.May.Week5;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 31-05-2020 00:10
*/

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule {
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] marked;

    public static void main(String[] args) {
        Course_Schedule ob = new Course_Schedule();
        System.out.println(ob.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(ob.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[numCourses];
        marked = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclic(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(int i) {
        visited[i] = true;
        for (Integer j : adj[i]) {
            if (!visited[j]) {
                if (isCyclic(j)) {
                    return true;
                }
            } else if (!marked[j]) {
                return true;
            }
        }
        marked[i] = true;
        return false;
    }
}
