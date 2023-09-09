package com.sharp.tree;

import java.util.*;

public class OrderTraversal {
    /**
     * 前序遍历 （中左右）
     * 递归
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }
    public void preOrder(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        res.add(node.val);
        preOrder(node.left,res);
        preOrder(node.right,res);
    }

    /**
     * 中序遍历 （左中右）
     * 递归
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res;
    }
    public void inOrder(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        preOrder(node.left,res);
        res.add(node.val);
        preOrder(node.right,res);
    }

    /**
     * 后序遍历 （左右中）
     * 递归
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root,res);
        return res;
    }
    public void postOrder(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        preOrder(node.left,res);
        preOrder(node.right,res);
        res.add(node.val);
    }

    /**
     * 前序遍历 (中左右)
     * 如果还有左子树就一直向下找，完了之后再返回从最底层逐步向上向右找。
     * 空节点不入栈
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root ==null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * 中序遍历 （左中右）
     * 先访问的是二叉树左子树的节点，然后一层一层向下访问，
     * 直到到达树左面的 最底部 ，再开始处理节点(也就是在把节点的数值放进res列表中)。
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 后序遍历 （左右中）
     * 反转法
     * 将前序遍历的左右颠倒。即：如果还有右子树就一直向下找，完了之后再返回从最底层逐步向上向左找。
     * 最后再将得到的结果集合反转，就得到后序遍历结果
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        Collections.reverse(res);
        return res;
    }


}
