package com.sharp.hashandqueue.队列实现栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列实现栈
 * LeetCode225 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 方法 ：入栈操作时，首先将元素入队到 queue2，然后将 queue1 的全部元素依次出队并入队到queue2
 * 再将 queue1 和 queue2 互换，则 queue1 的元素即为栈内的元素，queue 1的前端和后端分别对应栈顶和栈底
 */
class MyStack {
    Deque<Integer> queue1;
    Deque<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Deque<Integer> temp;
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}