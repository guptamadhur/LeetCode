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

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class First_Unique_Character_in_a_String {
    public static void main(String[] args) {
        First_Unique_Character_in_a_String ob = new First_Unique_Character_in_a_String();
        System.out.println(ob.firstUniqChar("loveleetcode"));
        System.out.println(ob.firstUniqueChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s.isEmpty())
            return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            Integer v = map.get(ch);
            if (v != null) {
                map.put(ch, new Integer(v + 1));
            } else {
                map.put(ch, 1);
            }
        }
        Map.Entry<Character, Integer> ss = map.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue)).get();
        return ss.getValue() > 1 ? -1 : s.indexOf(ss.getKey());
    }

    public int firstUniqueChar(String s) {
        if (s.isEmpty())
            return -1;
        int res=-1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            Integer v = map.get(ch);
            if (v != null) {
                map.put(ch, new Integer(v + 1));
            } else {
                map.put(ch, 1);
            }
        }
        for(Map.Entry<Character,Integer> val :map.entrySet()){
            if(val.getValue()==1){
                res = s.indexOf(val.getKey());
                break;
            }
        }
        return res;
    }
}
