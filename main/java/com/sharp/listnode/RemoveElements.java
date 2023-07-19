package com.sharp.listnode;

/**
 * 删除链表元素
 */
public class RemoveElements {
    /**
     * 删除特定结点
     * 方法：给链表添加一个虚拟表头dummyHead, dummyHead.next = head，通过 cur.next.val来判断
     * 找到目标元素的话，使用cur.next = cur.next.next来删除
     * 最后返回dummyHead.next
     * 添加虚拟表头可不用单独处理原头结点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 删除倒数第 N 个结点
     * ★方法1： 双指针！ ‘寻找倒数第 k 个指针’ + ‘删除结点 cur.next = cur.next.next’
     * 可给链表添加一个虚拟表头dummyHead, dummyHead.next = head
     * 添加虚拟表头可不用单独处理原头结点
     * --
     * 先将快指针指向正数第 K+1 个元素，慢指针指向第 1 个元素，此时两者正好相隔 K 个元素
     * 快慢指针同步向后走，当快指针指向尾结点 end.next == null 时，慢指针正好指向倒数第 K 个元素
     * 链表长度可能小于 K ，查找 K 的时候需要判断 fast 是否为 null
     * ---------------------------------------------------------------------
     * 方法2： 计算链表长度
     * 首先从头结点开始对链表进行一次遍历，得到链表的长度L，随后再从头结点开始对链表进行一次遍历，当遍历得到第 L - N + 1 个节点时
     * 它们就是需要删除的结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = dummyHead, fast = dummyHead;
        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

//    public ListNode removeNthFromEnd(ListNode head,int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int length = getLength(head);
//        ListNode cur = dummy;
//        for (int i = 1; i <  length - n + 1;++i){
//            cur = cur.next;
//        }
//        cur.next =  cur.next.next;
//        ListNode ans =  dummy.next;
//        return ans;
//    }
//        public int getLength(ListNode head){
//            int length = 0;
//            while (head != null){
//                ++length;
//                head = head.next;
//            }
//            return length;
//        }

    /**
     * 删除重复元素 - 重复元素保留一个。 升序链表
     * 方法 :给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，我们只需要对链表进行一次遍历，就可以删除重复的元素。
     * 从指针 cur 指向链表的头结点，随后开始对链表进行遍历。如果当前 cur 与cur.next 对应的元素相同，
     * 就将cur.next 从链表中移除；否则说明链表中已经不存在其它与 cur 对应的元素相同的节点，因此可以将 cur 指向 cur.next。
     * 当遍历完整个链表之后，返回链表的头结点即可。
     * 当遍历到链表的最后一个结点时，cur.next为空结点，此时要加以判断
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pHead = head;
        while(pHead.next != null){
            if(pHead.val == pHead.next.val){
                pHead.next = pHead.next.next;
            }else{
                pHead = pHead.next;
            }
        }
        return head;
    }

    /**
     * 删除重复元素 - 重复元素都不保留。 升序链表
     * 增加虚拟头结点，可直接对原头结点直接进行删除操作
     * 当一个都不要时，链表只要直接对cur.next以及cur.next.next 两个结点进行比较就行了，这里要注意两个 ->
     * -> node可能为空，稍加判断。
     * @param head
     * @return
     */
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null){
//            return head;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode cur = dummy;
//        while(cur.next != null && cur.next.next != null){
//            if(cur.next.val == cur.next.next.val){
//                int x = cur.next.val;
//                while(cur.next != null && cur.next.val == x){
//                    cur.next = cur.next.next;
//                }
//            }else{
//                cur = cur.next;
//            }
//        }
//        return dummy.next;
//    }
}



