package web.app.madhurgupta.challenge.May.Week3;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 20-05-2020 02:20
*/

import java.util.Stack;

public class Online_Stock_Span {
    Stack<int[]> stk = new Stack();

    public static void main(String[] args) {
        Online_Stock_Span ob = new Online_Stock_Span();
        int[] input = new int[]{100, 80, 60, 70, 60, 75, 85};
        for (int i : input) {
            System.out.print(ob.next(i) + " ");
        }
    }

    public int next(int price) {
        int span = 1;
        while (!stk.isEmpty() && price >= stk.peek()[0]) {
            span += stk.peek()[1];
            stk.pop();
        }
        stk.push(new int[]{price, span});
        return span;
    }
}
