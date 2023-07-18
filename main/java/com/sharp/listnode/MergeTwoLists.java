package com.sharp.listnode;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists {
    /**
     * 新建一个链表，然后分别遍历两个链表吗，每次都选最小的结点拼接到新链表上
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode res = newList;
        while(l1!=null || l2!=null){
            if(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    newList.next = l1;
                    l1 = l1.next;
                }else if(l1.val > l2.val){
                    newList.next = l2;
                    l2 = l2.next;
                }else{
                    newList.next = l1;
                    l1 = l1.next;
                    newList = newList.next;
                    newList.next = l2;
                    l2 = l2.next;
                }
                newList = newList.next;
            }else if(l1 == null && l2!=null){
                newList.next = l2;
                l2 = l2.next;
                newList = newList.next;
            }else if(l2 == null && l1!=null){
                newList.next = l1;
                l1 = l1.next;
                newList = newList.next;
            }
        }
        return res.next;
    }

    //---------------------------------------------------
    //第一个while的优化
//    while(list1 != null && list2!= null){
//        if(list1.val <= list2.val){
//            res.next = list1;
//            list1 = list1.next;
//        }else {
//            res.next = list2;
//            list2 = list2.next;
//        }
//        res = res.next;
//    }
//    res.next = list1 == null ? list2 : list1;
//    return newList.next;
    //----------------------------------------------------
}
