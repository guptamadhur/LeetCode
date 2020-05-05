package web.app.madhurgupta.challenge.may.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 06-05-2020 01:10
*/
/*
s = "leetcode"
return 0.

s = "loveleetcode",
return 2
*/

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class First_Unique_Character_in_a_String {
    public static void main(String[] args) {
        First_Unique_Character_in_a_String ob = new First_Unique_Character_in_a_String();
        System.out.println(ob.firstUniqChar(""));
    }
    public int firstUniqChar(String s) {
        if(s.isEmpty())
            return -1;
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(char ch :s.toCharArray()){
            Integer v = map.get(ch);
            if(v != null){
                map.put(ch,new Integer(v+1));
            }else{
                map.put(ch,1);
            }
        }
        Map.Entry<Character, Integer> ss = map.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get();
        return ss.getValue() > 1 ? -1 : s.indexOf(ss.getKey());
    }
}
