package web.app.madhurgupta.challenge.May.Week3;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 17-05-2020 02:54
*/

import web.app.madhurgupta.challenge.common.LinkedList.ListNode;

public class Odd_Even_Linked_List {
    private static ListNode root;
    private static ListNode tail;

    public static void main(String[] args) {
        Odd_Even_Linked_List ob = new Odd_Even_Linked_List();
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);
        ob.insert(5);
        ob.insert(6);
        ob.display(root);
        ob.display(ob.oddEvenList(root));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    protected void insert(int val) {
        if (root == null) {
            root = new ListNode(val);
            tail = root;
        } else {
            ListNode newNode = new ListNode();
            newNode.val = val;
            tail.next = newNode;
            tail = newNode;
        }
    }

    protected void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("null \n");
    }
}
