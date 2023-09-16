package com.sharp.tree.二叉树经典算法;

import com.sharp.tree.二叉树基础.TreeNode;

import java.util.LinkedList;

/**
 * 翻转的妙用
 */
public class Invert {
    /**
     * LeetCode226 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * 前序交换
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //后序交换
    //前序是先处理当前节点再处理子节点，是自顶向下
    //后序是先处理子结点最后处理自己，是自下而上的。
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }


    //层次遍历
    //核心思想是元素出队时，先将其左右两个孩子不是直接入队，而是先反转再放进去
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
//        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            //每次都从队列中拿一个节点，并交换这个节点的左右子树
//            TreeNode tmp = queue.poll();
//            TreeNode left = tmp.left;
//            tmp.left = tmp.right;
//            tmp.right = left;
//            //如果当前节点的左子树不为空，则放入队列等待后续处理
//            if (tmp.left != null) {
//                queue.add(tmp.left);
//            }
//            //如果当前节点的右子树不为空，则放入队列等待后续处理
//            if (tmp.right != null) {
//                queue.add(tmp.right);
//            }
//        }
//
//        return root;
//    }
}
