package web.app.madhurgupta.challenge.May.Week4;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 24-05-2020 17:01
*/

import web.app.madhurgupta.challenge.May.common.Tree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
    private BinaryNode root;

    public static void main(String[] args) {
        Construct_Binary_Search_Tree_from_Preorder_Traversal ob = new Construct_Binary_Search_Tree_from_Preorder_Traversal();
        ob.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    }

    public BinaryNode bstFromPreorder(int[] preorder) {
        for (int a : preorder) {
            insert(a);
        }
        display();
        return root;
    }

    private void display() {
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryNode node = stack.pop();
            System.out.print(node.val + ",");
            if (node.left != null && node.right == null || node.left == null && node.right != null)
                System.out.print(null + ",");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private void insert(int value) {
        BinaryNode newNode = new BinaryNode();
        newNode.val = value;
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (newNode.val < presentNode.val) {
                if (presentNode.left == null) {
                    presentNode.left = newNode;
                    break;
                } else {
                    queue.add(presentNode.left);
                }
            } else {
                if (presentNode.right == null) {
                    presentNode.right = newNode;
                    break;
                } else {
                    queue.add(presentNode.right);
                }
            }
        }
        return;
    }
}
