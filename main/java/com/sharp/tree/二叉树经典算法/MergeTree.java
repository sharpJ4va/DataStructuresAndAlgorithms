package com.sharp.tree.二叉树经典算法;

import com.sharp.tree.二叉树基础.TreeNode;

/**
 * 合并二叉树
 * LeetCode617 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。
 * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 注意：对一个节点进行合并之后，还要对该节点的左右子树分别进行合并
 */
public class MergeTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode merge = new TreeNode(root1.val + root2.val);
        merge.left = mergeTrees(root1.left,root2.left);
        merge.right = mergeTrees(root1.right,root2.right);
        return merge;
    }
}
