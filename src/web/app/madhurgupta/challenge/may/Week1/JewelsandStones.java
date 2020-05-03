package web.app.madhurgupta.challenge.may.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 04-05-2020 03:24
*/

/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

        The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

        Example 1:

        Input: J = "aA", S = "aAAbbbb"
        Output: 3
        Example 2:

        Input: J = "z", S = "ZZ"
        Output: 0
        Note:

        S and J will consist of letters and have length at most 50.
        The characters in J are distinct.
*/

import java.util.HashMap;

public class JewelsandStones {
    public static void main(String[] args) {
        JewelsandStones obj = new JewelsandStones();
        System.out.println(obj.numJewelsInStones("aA","aAAbbbb")); //3
        System.out.println(obj.numJewelsInStones("z","ZZ")); //0
    }

    public int numJewelsInStones(String J, String S) {
        char[] ch = J.toCharArray();
        char[] strArray = S.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        int total = 0;
        for (char c : ch) {
            if (charCountMap.containsKey(c)) {
                total += charCountMap.get(c);
            }
        }
        return total;
    }
}
