package com.sharp.tree.二叉树经典算法;

import com.sharp.tree.二叉树基础.TreeNode;

/**
 * 对称二叉树
 * LeetCode101 给定一个二叉树，检查它是否是镜像对称的。
 * 方法：将 LeetCode100 是否相同树 的比较结点调换
 * 左子树左节点与右子树右节点比较、左子树右节点与右子树左节点比较（外侧和外侧、内侧和内侧）
 */
public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        //关键
        return check(p.left,q.right) && check(p.right,q.left);
    }
}
