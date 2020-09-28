package web.app.madhurgupta.challenge.June;

import web.app.madhurgupta.challenge.common.Tree.BinaryNode;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 07-06-2020 01:06
*/


public class Invert_Binary_Tree {
    public static BinaryNode node;

    public static void main(String[] args) {
        Invert_Binary_Tree ob = new Invert_Binary_Tree();

    }

    public BinaryNode invertTree(BinaryNode root) {
        if (root == null)
            return root;
        if (root.left != null) {
            invertTree(root.left);
        } else {
            root.right = root.left;
        }
        return root;//TODO
    }
}