package web.app.madhurgupta.challenge.may.Week2;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 14-05-2020 03:48
*/

import java.util.Stack;

public class Remove_K_Digits {
    public static void main(String[] args) {
        Remove_K_Digits kDigits = new Remove_K_Digits();
        System.out.println(kDigits.removeKdigits("1432219", 3));
        System.out.println(kDigits.removeKdigits("10200", 1));
    }

    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (k == num.length()) return "0";
        Stack<Character> stk = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.peek() > c) {
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        for (int i = 0; i < k; i++) {
            stk.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
