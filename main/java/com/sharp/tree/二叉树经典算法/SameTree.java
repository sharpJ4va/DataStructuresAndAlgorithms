package com.sharp.tree.二叉树经典算法;

import com.sharp.tree.二叉树基础.TreeNode;

/**
 * 判断两棵树是否相同
 * LeetCode100 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 递归
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果都为空我们就认为他是相同的
        if(p==null && q==null){
            return true;
        }
        //如果一个为空，一个不为空，很明显不可能是相同的 树，直接返回false即可
        if(p==null||q==null){
            return false;
        }
        //如果对应位置的两个结点的值不相等，自然也不是同一个棵树
        if(p.val != q.val){
            return false;
        }
        //走到这一步说明节点p和q是完全相同的，接下来需要再判断其左左和右右是否满足要求了
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
