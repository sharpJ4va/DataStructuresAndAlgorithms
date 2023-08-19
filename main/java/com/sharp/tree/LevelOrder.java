package com.sharp.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 基本的层序遍历与变换
 */
public class LevelOrder {

    /**
     * LeetCode102 二叉树的层序遍历  ***重点*** 以下几种不同输出的层序遍历均为该方法的变种
     * 用一个变量size标记一下就行了，size表示某一层的元素个数，只要出队，就将size减1，减到0就说明该层元素访问完了。
     * 当size变成0之后，这时队列中剩余元素的个数恰好就是下一层元素的个数，
     * 因此重新将size标记为下一层的元素个数就可以继续处理新的一行
     * 最后，把每层遍历到的节点都放入到一个结果集中，将其返回就可以了
     *
     * @param root 根节点
     * @return
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            //获取当前队列的长度，也就是当前这一层的元素个数
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点左/右子树不为空，也放入队列中
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            //此时的tmp就是当前层的全部元素，用List类型的tmp保存，加入最终结果集中
            res.add(tmp);
        }
        return res;
    }

    /**
     * LeetCode 107.给定一个二叉树，返回其节点值 自底向上 的层序遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）。
     * 只需将 自上而下 的结果反过来 即得到自底向上
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            //获取当前队列的长度，也就是当前这一层的元素个数
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点左/右子树不为空，也放入队列中
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            //此时的tmp就是当前层的全部元素，用List类型的tmp保存，加入最终结果集中
            //将存储该层节点值的列表添加到结果列表的 头部
            res.add(0, tmp); //***关键***
        }
        return res;
    }

    /**
     * LeetCode103 题，要求是：给定一个二叉树，返回其节点值的锯齿形层序遍历。
     * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * 利用「双端队列」的数据结构来维护当前层节点值输出的顺序。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        boolean isOrderLeft = true; //标记层数
        deque.add(root);
        while (deque.size() != 0) {
            int size = deque.size();
            Deque<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = deque.remove();
                //奇数层则插在队尾
                if (isOrderLeft) {
                    tmp.addLast(t.val);
                    //偶数层则插在队头
                } else {
                    tmp.addFirst(t.val);
                }
                if (t.left != null) {
                    deque.add(t.left);
                }
                if (t.right != null) {
                    deque.add(t.right);
                }
            }
            res.add(new LinkedList<>(tmp)); //转类型  Deque -> List
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
