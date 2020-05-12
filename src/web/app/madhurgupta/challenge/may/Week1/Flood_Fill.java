package web.app.madhurgupta.challenge.may.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 12-05-2020 01:37
*/

public class Flood_Fill {
    public static void main(String[] args) {
        Flood_Fill ob = new Flood_Fill();
        int[][] ar = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println("Before:");
        ob.display(ar);
        System.out.println("\n" + "After:");
        ob.display(ob.floodFill(ar, 1, 1, 2));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fill(int[][] image, int i, int j, int color, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != color) {
            return;
        }
        image[i][j] = newColor;
        fill(image, i + 1, j, color,newColor);
        fill(image, i - 1, j, color,newColor);
        fill(image, i, j + 1, color,newColor);
        fill(image, i, j - 1, color,newColor);
    }

    void display(int[][] ar) {
        for (int[] a : ar) {
            for (int b : a)
                System.out.print(b + " ");
            System.out.println();
        }
    }
}
