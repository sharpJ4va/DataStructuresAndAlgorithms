package com.sharp.listnode;

import static com.sharp.listnode.MergeTwoLists.mergeTwoLists;

/**
 * 合并K个有序链表
 */
public class MergeKLists {
    /**
     * 先将前两个合并，之后再将后面的逐步合并起来
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        ListNode res = null;
        for(ListNode list : lists){
            res = mergeTwoLists(res,list);
        }
        return res;
    }
}
