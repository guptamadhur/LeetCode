package web.app.madhurgupta.challenge.May.Week3;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 20-05-2020 23:37
*/

import web.app.madhurgupta.challenge.May.common.Tree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class Kth_Smallest_Element_in_a_BST {
    public static BinaryNode node;
    int cnt, ans;

    public static void main(String[] args) {
        Kth_Smallest_Element_in_a_BST ob = new Kth_Smallest_Element_in_a_BST();
        int i = 1;
        while (i < 6) {
            ob.insert(i);
            i++;
        }
        i = 10;
        while(i > 3){
            ob.insert(i);
            i--;
        }
        System.out.println("kthSmallest :"+ob.kthSmallest(node, 3));
        System.out.println("kthSmallest :"+ob.kthSmallest(node, 1));
    }

    private int kthSmallest(BinaryNode root, int k) {
        cnt = 0;
        inorder(root, k);
        return ans;
    }

    private void inorder(BinaryNode root, int k) {
        if (root == null)
            return;
        inorder(root.left, k);
        cnt++;
        if (cnt == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }

    private void insert(int val) {
        BinaryNode newNode = new BinaryNode();
        newNode.val = val;
        if (node == null) {
            node = newNode;
            System.out.println("Successfully inserted new node at Root !");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.left == null) {
                presentNode.left = newNode;
                System.out.println("Successfully inserted new node in left!" + presentNode.val);
                break;
            } else if (presentNode.right == null) {
                presentNode.right = newNode;
                System.out.println("Successfully inserted new node in right!" + presentNode.val);
                break;
            } else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }//end of else-if
        }//end of loop
    }
}
