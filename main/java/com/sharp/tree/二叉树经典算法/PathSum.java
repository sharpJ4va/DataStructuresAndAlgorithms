package com.sharp.tree.二叉树经典算法;

import com.sharp.tree.二叉树基础.TreeNode;

/**
 * 路径总和
 * LeetCode112题：给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum。
 * 方法：将这个大问题转化为一个小问题：是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
 * 若当前节点就是叶子节点，那么直接判断 sum 是否等于 val 即可
 * 若当前节点不是叶子节点，我们只需要递归地询问它的子节点是否能满足条件即可。
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return targetSum == root.val;
        }
        boolean left = hasPathSum(root.left,targetSum-root.val);
        boolean right = hasPathSum(root.right,targetSum-root.val);
        return left || right;
    }
}
