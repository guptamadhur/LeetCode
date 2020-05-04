package web.app.madhurgupta.challenge.may.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 05-05-2020 01:03
*/

/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

        Example 1:

        Input: 5
        Output: 2
        Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

        Example 2:

        Input: 1
        Output: 0
        Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

        Note:

        The given integer is guaranteed to fit within the range of a 32-bit signed integer.
        You could assume no leading zero bit in the integer’s binary representation.
        This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
*/

public class NumberComplement {

    public static void main(String[] args) {
        NumberComplement ob = new NumberComplement();
        int N = 10;
        System.out.println(ob.bitwiseComplement(N));
    }

    public int bitwiseComplement(int N) {
        String str= "";
        for (char a : Integer.toString(N, 2).toCharArray()) {
            if (a == '1') {
                str = str +"0";
            } else {
                str = str +"1";
            }
        }
        return Integer.parseInt(str,2);
    }
}
