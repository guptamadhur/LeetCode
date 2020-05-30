package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 30-05-2020 23:59
*/

public class Counting_Bits {
    public static void main(String[] args) {
        Counting_Bits ob = new Counting_Bits();
        System.out.println(ob.countBits(5));
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
