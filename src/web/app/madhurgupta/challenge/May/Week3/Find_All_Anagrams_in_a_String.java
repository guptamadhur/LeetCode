package web.app.madhurgupta.challenge.May.Week3;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 17-05-2020 13:07
*/

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String {
    int MAX = 256; //All LowerCase English letters

    public static void main(String[] args) {
        Find_All_Anagrams_in_a_String ob = new Find_All_Anagrams_in_a_String();
        List<Integer> list;
        list = ob.findAnagrams("", "a");
        ob.display(list);
        list = ob.findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa");
        ob.display(list);
        list = ob.findAnagrams("cbaebabacd", "abc");//[0, 6]
        ob.display(list);
        list = ob.findAnagrams("abab", "ab");//[0, 1, 2]
        ob.display(list);
    }

    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sMax = s.length(), pMax = p.length();
        if (sMax == 0) return list;
        if (pMax == 0) {
            for (int i = 0; i < s.length(); i++) {
                list.add(i);
            }
        }
        if(pMax > sMax) return list;

        char[] countp = new char[MAX];
        char[] counts = new char[MAX];

        for (int i = 0; i < pMax; i++) {
            (countp[p.charAt(i)])++;
            (counts[s.charAt(i)])++;
        }
        for (int i = pMax; i < sMax; i++) {
            if (compare(countp, counts))
                list.add(i - pMax);
            (counts[s.charAt(i)])++; //Adding +1 for the New Letter to count to list
            counts[s.charAt(i - pMax)]--;//-1 for previous letter
        }

        if (compare(countp, counts))
            list.add(sMax - pMax);

        return list;
    }

    private boolean compare(char[] c1, char[] c2) {
        for (int i = 0; i < MAX; i++)
            if (c1[i] != c2[i])
                return false;
        return true;
    }

    private void display(List<Integer> list) {
        System.out.print("Output: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
