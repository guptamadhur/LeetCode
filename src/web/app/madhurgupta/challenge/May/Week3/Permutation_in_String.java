package web.app.madhurgupta.challenge.May.Week3;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 19-05-2020 01:10
*/

public class Permutation_in_String {
    int MAX = 256;

    public static void main(String[] args) {
        Permutation_in_String ob = new Permutation_in_String();
        System.out.println(ob.checkInclusion("ab", "eidbaooo"));
        System.out.println(ob.checkInclusion("ab", "eidboaoo"));
        System.out.println(ob.checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int s1Max = s1.length(), s2Max = s2.length(), res = 0;
        if (s1Max == 0) return true;
        if (s2Max == 0 || s1Max > s2Max) return false;

        char[] s1Counts = new char[MAX];
        char[] s2Counts = new char[MAX];
        for (int i = 0; i < s1Max; i++) {
            (s1Counts[s1.charAt(i)])++;
            (s2Counts[s2.charAt(i)])++;
        }
        for (int i = s1Max; i <s2Max; i++) {
            if (compare(s1Counts, s2Counts))
                res++;
            (s2Counts[s2.charAt(i)])++;
            (s2Counts[s2.charAt(i - s1Max)])--;
        }
        if (compare(s1Counts, s2Counts))
            res++;
        return res > 0;
    }

    private boolean compare(char[] s1Counts, char[] s2Counts) {
        for (int i = 0; i < MAX; i++)
            if (s1Counts[i] != s2Counts[i])
                return false;
        return true;
    }
}
