package com.sharp.listnode.反转链表基础;

import com.sharp.listnode.单链表基础.ListNode;

/**
 * 链表反转
 */
public class ReverseList {
    /**
     * 虚拟结点法 / 头插法
     * 遍历的每个元素都插到虚拟头结点的“后面一位”
     * @param head
     * @return 返回虚拟头结点的后一位
     */
//    public ListNode reverseList(ListNode head){
//        ListNode ans = new ListNode(-1);
//        ListNode cur = head;
//        while(cur != null){
//            ListNode next = cur.next;
//            cur.next = ans.next;
//            ans.next = cur;
//            cur = next;
//        }
//        return ans.next;
//    }

    /**
     * ★穿针引线法
     * 将遍历的每个结点的next都指向 prev ， 再将 prev 指向当前结点
     * @param head
     * @return
     */
//    public ListNode reverseList(ListNode head){
//        ListNode cur = head, prev = null;
//        while(cur != null){
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }

    /**
     * 递归法
     * 一直递归到最后一个元素后开始跳出当前递归层，等价于从后往前遍历，跳出后来到上一层
     * 再将本层（本层==来到的上一层）结点的后一位结点的next指向本层结点
     * 随后擦除本层结点next对后一位结点的指向
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
