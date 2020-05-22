package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 23-05-2020 02:02
*/

import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        Sort_Characters_By_Frequency ob = new Sort_Characters_By_Frequency();
        System.out.println(ob.frequencySort("Aabb")); //bbAa
        System.out.println(ob.frequencySort("cccaaa")); //cccaaa
        System.out.println(ob.frequencySort("tree")); //eert
    }

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chFreq = new char[256];
        for (char ch : s.toCharArray()) {
            chFreq[ch]++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> chFreq[b] - chFreq[a]);
        for (int i = 0; i < 256; i++) {
            pq.offer((char) i);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            for (int i = 0; i < chFreq[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
