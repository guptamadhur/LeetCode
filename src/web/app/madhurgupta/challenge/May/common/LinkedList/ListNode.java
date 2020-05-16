package web.app.madhurgupta.challenge.May.common.LinkedList;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 17-05-2020 03:13
*/

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}