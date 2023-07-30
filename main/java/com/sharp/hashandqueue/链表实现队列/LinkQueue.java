package com.sharp.hashandqueue.链表实现队列;

public class LinkQueue {
    private Node front;
    private Node rear;
    private int size;
    public LinkQueue(){
        this.front = new Node(0);
        this.rear = new Node(0);
    }

    /**
     * 入队
     * @param value
     */
    public void push(int value){
        Node newNode = new Node(value);
        Node temp = front;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        rear = newNode;
        size++;
    }

    /**
     * 出队
     * @return
     */
    public int pull(){
        if(front.next == null){
            System.out.println("队列已空");
        }
        Node firstNode = front.next;
        front.next = firstNode.next;
        size--;
        return firstNode.data;
    }

    /**
     * 遍历队列
     */
    public void traverse(){
        Node temp = front.next;
        while (temp != null){
            System.out.println(temp.data + "\t");
            temp = temp.next;
        }
    }
    static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }
}










