package com.sharp.Stack.栈经典算法;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大栈
 * LeetCode 716.设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。 能查找或弹出最大值
 * 方法 ： 使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最大值
 * 弹出最大值 ： 将两个栈同时出栈，并存储第一个栈出栈的所有值。当第一个栈的出栈元素等于当前栈中最大的元素值时，就找到了最大的元素
 * 出栈的时候将弹出的元素保存到临时栈中，弹出最大元素后再复原。不必考虑maxStack的复原，因为它是随主栈变化的
 */
public class MaxStack {
    Deque<Integer> xStack;
    Deque<Integer> maxStack;
    public MaxStack(){
        xStack = new LinkedList<Integer>();
        maxStack = new LinkedList<Integer>();
    }
    public void push(int x){
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(Math.max(max,x));
        xStack.push(x);

    }
    public int pop(){
        maxStack.pop();
        return xStack.pop();
    }
    public int top(){
        return xStack.peek();
    }
    public int peekMax(){
        return maxStack.peek();
    }
    public int popMax(){
        int max = peekMax();
        Deque<Integer> buffer = new LinkedList<>();
        while(top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }
}
