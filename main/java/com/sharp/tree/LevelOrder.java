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
     * 二叉树的层序遍历
     * 用一个变量size标记一下就行了，size表示某一层的元素个数，只要出队，就将size减1，减到0就说明该层元素访问完了。
     * 当size变成0之后，这时队列中剩余元素的个数恰好就是下一层元素的个数，
     * 因此重新将size标记为下一层的元素个数就可以继续处理新的一行
     * 最后，把每层遍历到的节点都放入到一个结果集中，将其返回就可以了
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
}
