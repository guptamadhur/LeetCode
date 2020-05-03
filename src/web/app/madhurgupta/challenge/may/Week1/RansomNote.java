package web.app.madhurgupta.challenge.may.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 03-05-2020 21:27
*/

/*
Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise,
it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

/*
    Knuth–Morris–Pratt(KMP) Pattern Matching(Substring search)
    O(m+n)
*/

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static String[] ransomNote = {"", "", "aa", "aa", "fihjjjjei", "fffbfg", "bjaajgea", "bg", "a"};
    public static String[] magazine = {"", "ab", "ab", "aab", "hjibagacbhadfaefdjaeaebgi", "effjfggbffjdgbjjhhdegh", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj", ""};
    public static String[] res = {"true", "", "false", "true", "false", "", "", ""};

    public static void main(String[] args) {
        RansomNote obj = new RansomNote();

        for (int i = 0; i < 8; i++) {
            System.out.println("String : " + ransomNote[i] + " " + magazine[i]);

            HashMap<Character, Integer> map = obj.characterCount(ransomNote[i]);
            HashMap<Character, Integer> map1 = obj.characterCount(magazine[i]);

            boolean b = true;
            for (Map.Entry mapElement : map.entrySet()) {
                Character key = (Character) mapElement.getKey();
                int value = (int) mapElement.getValue();
                if (map1.containsKey(key)) {
                    if (map1.get(key) < value) {
                        b = false;
                        break;
                    }
                } else {
                    b = false;
                    break;
                }
            }

            System.out.print("--" + res[i] + ": " + b);
            System.out.println();
            System.out.println();
        }
    }//end of method

    public HashMap<Character, Integer> characterCount(String inputString) {
        // Creating a HashMap containing char as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();

        // Converting given string to char array
        char[] strArray = inputString.toCharArray();
        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
                // If char is present in charCountMap, incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                // If char is not present in charCountMap, putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }
        // Printing the charCountMap
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + "  ");
        }
        System.out.println();
        return charCountMap;
    }//end of method
}//end of class
