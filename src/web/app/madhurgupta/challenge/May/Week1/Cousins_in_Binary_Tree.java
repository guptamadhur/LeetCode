package web.app.madhurgupta.challenge.May.Week1;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 08-05-2020 00:50
*/

/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false
Example 2:
    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

*/

import web.app.madhurgupta.challenge.May.Week1.common.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins_in_Binary_Tree {

    static TreeNode treeNode;
    public TreeNode xParent = null, yParent = null;
    public int xDepth = -1, yDepth = -2;

    public static void main(String[] args) {
        Cousins_in_Binary_Tree ob = new Cousins_in_Binary_Tree();
        treeNode = new TreeNode();
        int[] aa = {12, 1, 45, 54, 6, 78, 4, 53, 2, 12, 10};
        for (int value : aa) {
            ob.insert(value);
        }
        ob.printTreeNode();
        System.out.println(ob.isCousins(treeNode, 4, 12));
        System.out.println(ob.isCousins(treeNode, 4, 53));
    }


    public boolean isCousins(TreeNode node, int x, int y) {
        dfs(node, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    void dfs(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) return;
        if (x == node.getValue()) {
            xParent = parent;
            xDepth = depth;
        } else if (y == node.getValue()) {
            yParent = parent;
            yDepth = depth;
        } else {
            // if we found x node or found y node then we don't need to dfs deeper
            //because x and y must be the same depth
            dfs(node.getLeft(), node, x, y, depth + 1);
            dfs(node.getRight(), node, x, y, depth + 1);
        }
    }

    public void printTreeNode() {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        int currentLevel = 1;
        boolean previousLevelwasAllNull = false;
        queue.add(treeNode);
        level.add(1);
        if (treeNode == null) {
            System.out.println("Tree doesn't node have Values");
            return;
        }
        while (!queue.isEmpty()) {
            if (currentLevel == level.peek()) {
                if (queue.peek() == null) {
                    queue.add(null);
                    level.add(currentLevel + 1);
                } else {
                    queue.add(queue.peek().getLeft());
                    level.add(currentLevel + 1);
                    queue.add(queue.peek().getRight());
                    level.add((currentLevel + 1));
                    previousLevelwasAllNull = false;
                }
                TreeNode t = queue.remove();
                String val = t != null ? String.valueOf(t.getValue()) : null;
                System.out.print(val + " ");
                level.remove();
            } else {
                System.out.println("\n");
                currentLevel++;
                if (previousLevelwasAllNull) {
                    break;
                }
                previousLevelwasAllNull = true;
            }
        }

    }

    // Insert values in BST
    public void insert(int value) {
        treeNode = insert(treeNode, value);
    }

    TreeNode insert(TreeNode currentNode, int value) {
        if (currentNode == null) {
            TreeNode node = new TreeNode();
            node.setValue(value);
            return node;
        }
        if (value <= currentNode.getValue()) {
            currentNode.setLeft(insert(currentNode.getLeft(), value));
            return currentNode;
        } else {
            currentNode.setRight(insert(currentNode.getRight(), value));
            return currentNode;
        }
    }
}
