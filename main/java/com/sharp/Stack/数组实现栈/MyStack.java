package com.sharp.Stack.数组实现栈;

import java.util.Arrays;

public class MyStack<T> {
    //实现栈的数组
    private Object[] stack;
    //栈顶元素
    private int top;

    MyStack() {
        //初始容量10
        stack = new Object[10];
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == 0;
    }

    //返回栈顶元素
    public T peek() {
        T t = null;
        if (top > 0) {
            t = (T) stack[top - 1];
        }
        return t;
    }

    //入栈
    public void push(T t) {
        expandCapacity(top + 1);
        stack[top] = t;
        top++;
    }

    //出栈
    public T pop() {
        T t = peek();
        if (top > 0) {
            stack[top - 1] = null;
            top--;
        }
        return t;
    }

    //扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }
}
































