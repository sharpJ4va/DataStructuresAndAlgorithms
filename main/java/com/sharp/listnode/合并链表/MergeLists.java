package com.sharp.listnode.合并链表;

import com.sharp.listnode.单链表基础.ListNode;

/**
 * 合并链表
 */
public class MergeLists {
    /**
     * 合并两个有序链表
     * 新建一个链表，然后分别遍历两个链表吗，每次都选最小的结点拼接到新链表上
     * @param l1
     * @param l2
     * @return
     */
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode newList = new ListNode(-1);
//        ListNode res = newList;
//        while(l1!=null || l2!=null){
//            if(l1!=null && l2!=null){
//                if(l1.val<l2.val){
//                    newList.next = l1;
//                    l1 = l1.next;
//                }else if(l1.val > l2.val){
//                    newList.next = l2;
//                    l2 = l2.next;
//                }else{
//                    newList.next = l1;
//                    l1 = l1.next;
//                    newList = newList.next;
//                    newList.next = l2;
//                    l2 = l2.next;
//                }
//                newList = newList.next;
//            }else if(l1 == null && l2!=null){
//                newList.next = l2;
//                l2 = l2.next;
//                newList = newList.next;
//            }else if(l2 == null && l1!=null){
//                newList.next = l1;
//                l1 = l1.next;
//                newList = newList.next;
//            }
//        }
//        return res.next;
//    }

    /**
     * 合并两个有序链表 （优化后）
     * 新建一个链表，然后分别遍历两个链表吗，每次都选最小的结点拼接到新链表上
     * 如果两个链表存在相同元素，第一次出现时使用if (l1.val <= l2.val)来处理，后面一次则会被else处理掉
     * 一个链表为空后，另一个链表的全部结点直接拼到最后
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(0);
        ListNode res = newList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        res.next = list1 == null ? list2 : list1;
        return newList.next;
    }
    /**
     * 合并K个有序链表
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

    /**
     * 合并两个链表
     * 将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置
     *  方法：按部就班，找到链表1保留部分的尾结点和链表2的尾结点，将两链表链接起来。
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre1 = list1, post1 = list1, post2 = list2;
        int i = 0 , j = 0;
        while(pre1 != null && post1 != null && j <= b){
            if(i != a - 1){
                pre1 = pre1.next;
                i++;
            }
            post1 = post1.next;
            j++;
        }

        while(post2.next != null){
            post2 = post2.next;
        }
        post2.next = post1;
        pre1.next = list2;
        return list1;
    }
}
