package com.sharp.listnode;

/**
 * 单链表
 */
public class ListNode {
    //规范定义链表
//    private int data;
//    private ListNode next;
//    public ListNode(int data){
//        this.data = data;
//    }
//    public int getData(){
//        return data;
//    }
//    public void setData(int data){
//        this.data = data;
//    }
//    public ListNode getNext(){
//        return next;
//    }
//    public void setNext(ListNode next){
//        this.next = next;
//    }

    //违背面向对象的设计要求，但是更为精简，在算法题目中应用广泛
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }

    /**
     * 遍历链表
     * @param head 头结点
     * @return 返回链表长度
     */
    public static int getListLength(ListNode head){
        int length = 0;
        ListNode node = head;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 链表插入  考虑首部，中部，尾部
     * @param head 链表头结点
     * @param nodeInsert 待插入结点
     * @param position 待插入位置，从 1 开始
     * @return 插入后得到的链表头结点
     */
    public static ListNode insertNode(ListNode head,ListNode nodeInsert,int position){
        if(head == null){
        //认为待插入的结点就是链表的头结点，也可以抛出不能插入的异常
        return nodeInsert;
        }
        //已经存放的元素个数
        int size = getListLength(head);
        if(position > size + 1 || position < 1){
            System.out.println("位置参数越界");
            return head;
        }

        //表头插入
        if(position == 1){
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }

        //4 15 7 40
        //在7前面插入， 当cur.next==node(7)就停下来，此时cur.val==15
        //先new.next=node(15).next  再node(15).next=new 顺序不能错，先后再前
        ListNode pNode = head;
        int count = 1;
        //position在上面被size限制了，不用考虑pNode == null
        while (count < position - 1){
            pNode = pNode.next;
            count++;
        }
        nodeInsert.next = pNode.next;
        pNode.next = nodeInsert;
        return head;
    }

    /**
     * 删除结点 考虑首部，中部，尾部
     * @param head 链表头位置
     * @param position 删除结点位置，从 1 开始
     * @return  删除后的链表头结点
     */
    public static ListNode deleteNode(ListNode head,int position){
        if(head == null){
            return null;
        }
        int size = getListLength(head);
        if(position > size || position < 1){
            //删除最后一个结点只需要遍历到 -2 位置 所以只需要size而不是size+1
            System.out.println("输入的位置参数有误");
            return head;
        }
        //删除头结点只需要head = head.next; head向前移动一次后，原来的结点不可达，会被JVM回收、
        //删除尾结点只需要cur.next=null; 同理不可达，会被JVM回收
        if(position == 1){
            //curNode就是链表的新头结点
            return head.next;
        }else{
            ListNode preNode = head;
            int count = 1;
            while (count < position -1){
                preNode = preNode.next;
                count++;
            }
            ListNode curNode = preNode.next;
            preNode.next = curNode.next;
        }
        return head;
    }
}



























































