package com.sharp.listnode.反转链表进阶;

import com.sharp.listnode.单链表基础.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 反转链表Ⅱ
 */
public class ReverseList2 {
    /**
     * 指定区间反转
     * 方法 1 ：头插法
     * 在需要反转的区间里，每遍历到一个节点，让这个新结点来到反转部分的起始位置
     * @param head
     * @param left
     * @param right
     * @return
     */
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        for(int i = 0 ; i < left - 1; i++){
//            prev = prev.next;
//        }
//        ListNode cur = prev.next;
//        ListNode next;
//        for(int i = 0 ; i < right - left; i++){
//            next = cur.next;
//            cur.next = next.next;
//            next.next = prev.next;
//            prev.next = next;
//        }
//        return dummyHead.next;
//    }

    /**
     * 指定区间反转
     * 方法 2 ：穿针引线法
     * 将需要反转部分截取下来，反转（将遍历的每个结点的next都指向 prev ， 再将 prev 指向当前结点）之后再拼上去
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //头结点可能发生变化，设置虚拟头结点以避免复杂讨论
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //保存前驱节点prev、后驱结点succ，以便后续拼接
        ListNode prev = dummyHead;
        for(int i = 0; i < left - 1; i++){
            prev = prev.next;
        }
        ListNode rightNode = prev;
        for(int i = 0 ; i < right - left + 1 ; i++){
            rightNode = rightNode.next;
        }
        //切除一个子链表
        ListNode leftNode = prev.next;
        ListNode succ = rightNode.next;
        //子链表前后都要断开
        prev.next = null;
        rightNode.next = null;
        //子链表反转
        reverseList(leftNode);
        prev.next = rightNode;
        leftNode.next = succ;
        return dummyHead.next;

    }
    private void reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while( cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }

    /**
     * 两两交换链表中的结点
     * 方法 : 增加虚拟头结点，取dummyHead.next和dummyHead.next.next来交换位置
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while(temp.next != null && temp.next.next != null){
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    /**
     * 单链表加一
     * 用一个非空单链表来表示一个非负整数，然后将这个整数加一。
     * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
     * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
     * 方法 ： 计算从低位开始，而链表是从高位开始，因此需要将链表反转过来，可以使用栈 或者 链表反转
     * 依次取出栈顶数字进行相加，考虑进位，然后拼接到新链表的next
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        int adder = 1;
        while( !stack.isEmpty() || adder != 0 || carry > 1){
            int digit = stack.isEmpty() ? 0 : stack.pop();
            int sum = digit + adder + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode cur = new ListNode(sum);
            cur.next = dummyHead.next;
            dummyHead.next = cur;
            adder = 0;
        }
        return dummyHead.next;
    }

    /**
     * 单链表加法
     * 单链表加一 的变形
     * 给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字
     * 将这两数相加会返回一个新的链表。你可以假设除了数字 0 之外，这两个数字都不会以零开头
     * 方法 1 ：栈方法 计算从低位开始，而链表是从高位开始，因此需要将链表反转过来，可以使用栈 或者 链表反转
     * 依次取出栈顶数字进行相加，考虑进位，然后拼接到新链表的next
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Deque<Integer> stack1 = new LinkedList<Integer>();
//        Deque<Integer> stack2 = new LinkedList<Integer>();
//        while(l1 != null){
//            stack1.push(l1.val);
//            l1 = l1.next;
//        }
//        while(l2 != null){
//            stack2.push(l2.val);
//            l2 = l2.next;
//        }
//        ListNode dummy = new ListNode(0);
//        int carry = 0;
//        while(!stack1.isEmpty() || !stack2.isEmpty() || carry!= 0 ){
//            int adder1 = stack1.isEmpty() ? 0 : stack1.pop();
//            int adder2 = stack2.isEmpty() ? 0 : stack2.pop();
//            int sum = adder1+adder2+carry;
//            carry = sum >= 10 ? sum/10 : 0;
//            sum = sum >=10 ? sum%10 : sum;
//            ListNode cur = new ListNode(sum);
//            cur.next = dummy.next;
//            dummy.next = cur;
//        }
//        return dummy.next;
//    }
//------------------------------------------------------------

    /**
     * 单链表加法
     * 方法 2 ：使用链表反转实现，先将两个链表分别反转，最后计算完之后再将结果反转
     * 一共有三次反转操作，所以将反转抽取出一个方法比较好
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val = carry;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return reverse(head.next);
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
//------------------------------------------------------------

    /**
     * 回文链表
     * 方法 ： 快慢指针 + 链表反转
     * 反转一半链表后与另一半链表进行比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,fast = head;
        ListNode pre = null,prepre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(prepre != null && slow != null){
            if(prepre.val != slow.val){
                return false;
            }
            prepre = prepre.next;
            slow = slow.next;
        }
        return true;
    }
}
























