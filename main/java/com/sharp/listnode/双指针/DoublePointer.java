package com.sharp.listnode.双指针;

import com.sharp.listnode.单链表基础.ListNode;

/**
 * 双指针
 */
public class DoublePointer {
    /**
     * 寻找中间结点
     * 快指针走两步，慢指针走一步，快指针走完的时候，快指针走完的时候，慢指针处于中间
     * 如果节点数是偶数的时候，慢指针处于最中间两个结点的后面那个结点，
     * 因为偶数的时候快指针不能正好走完指向最后一个，要多走一次，慢指针也随之多走一次，画图即清晰
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head){
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 寻找倒数第K个元素
     * 先将快指针指向正数第 K+1 个元素，慢指针指向第 1 个元素，此时两者正好相隔 K 个元素
     * 快慢指针同步向后走，当快指针指向尾结点 end.next == null 时，慢指针正好指向倒数第 K 个元素
     * 链表长度可能小于 K ，查找 K 的时候需要判断 fast 是否为 null
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head , int k){
        ListNode slow = head, fast = head;
        while(fast != null && k > 0){
            fast = fast.next;
            k--;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    /**
     * 旋转链表
     * 先用双指针找到倒数 K 的位置，然后将 K 位置元素保存起来，再与前面断开，即 res = K ， k-1）.next = null ，
     * 再将尾结点与头结点拼接
     *  ！！！ 注意： 需要考虑 k 的大小， 如果 k 大于链表长度，k % len == 0的话，直接返回。 否则找 k % len 位置的元素（取余数）
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode temp = head, slow = head, fast = head, res = null;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        if(k % len == 0){
            return head;
        }
        while(k % len > 0){
            fast = fast.next;
            k--;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }

}
