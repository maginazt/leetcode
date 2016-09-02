package com.maginazt.page2;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/9/1.
 */
public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty())
            minStack.push(x);
        else
            minStack.push(Math.min(minStack.peekFirst(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
