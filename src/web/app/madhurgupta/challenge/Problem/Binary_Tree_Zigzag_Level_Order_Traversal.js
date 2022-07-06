
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode
# Created on: 06-07-2022 09:00


https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

*/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */

 var zigzagLevelOrder = function(root) {
    let results = [];
    
    const lot = (root, level) =>{
        if(!root) return ;
        
        if(results[level]) results[level].push(root.val);
        else results[level] = [root.val];
        
        lot(root.left, level + 1);
        lot(root.right, level + 1);
    }
    lot(root, 0);
    return results.map((x, i)=>(i%2) ? x.reverse() : x);
};

