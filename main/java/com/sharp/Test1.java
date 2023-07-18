package com.sharp;
import com.sharp.listnode.ListNode;
import com.sharp.listnode.FindFirstCommonNode;

public class Test1 {
    public static void main(String[] args) {
        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) {
         *         val = x;
         *         next = null;
         *     }
         * }
         */
        ListNode head1 = new ListNode(1);
        ListNode head8 = new ListNode(8);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        ListNode headA = new ListNode(4);
        ListNode.insertNode(headA,head1,2);
        ListNode.insertNode(headA,head8,3);
        ListNode.insertNode(headA,head4,4);
        ListNode.insertNode(headA,head5,5);

        ListNode headB = new ListNode(5);
        ListNode.insertNode(headB,new ListNode(0),2);
        ListNode.insertNode(headB,head1,3);
        ListNode.insertNode(headB,head8,4);
        ListNode.insertNode(headB,head4,5);
        ListNode.insertNode(headB,head5,6);

//        ListNode headA = new ListNode(4);
//        ListNode.insertNode(headA,new ListNode(5),2);
//        ListNode.insertNode(headA,new ListNode(6),3);
//
//
//        ListNode headB = new ListNode(1);
//        ListNode.insertNode(headB,new ListNode(2),2);
//        ListNode.insertNode(headB,new ListNode(3),3);


        ListNode b = FindFirstCommonNode.getIntersectionNode(headA,headB);
        System.out.println(b.val);
    }
}
