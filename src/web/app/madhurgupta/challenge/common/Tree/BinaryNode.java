package web.app.madhurgupta.challenge.common.Tree;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 20-05-2020 23:48
*/

public class BinaryNode {
    public int val;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode() {
    }

    public BinaryNode(int val) {
        this.val = val;
    }

    public BinaryNode(int val, BinaryNode left, BinaryNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
