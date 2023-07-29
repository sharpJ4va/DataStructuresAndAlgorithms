package com.sharp.Stack.栈经典算法;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小栈
 * LeetCode 155，设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈
 *  方法 ： 使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack(){
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    public void push(int x){
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }
    public void pop(){
        xStack.pop();
        minStack.pop();
    }
    public int top(){
        return xStack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}
