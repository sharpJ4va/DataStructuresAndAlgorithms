package com.sharp.tree.二叉树经典算法;

import com.sharp.tree.二叉树基础.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * LeetCode257：给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 注意：叶子节点是指没有子节点的节点。
 * String类型的变量中，访问每个节点访问的时候先存到String中，到叶子节点的时候再添加到集合里（记录中间节点）
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        return res;
    }
    void dfs(TreeNode root,String path,List<String> res){
        if(root==null){
            return;
        }
        if(root.left==null && root.right == null){
            res.add(path + root.val);
            return;
        }
        dfs(root.left,path + root.val + "->",res);
        dfs(root.right,path + root.val + "->",res);
    }
}
