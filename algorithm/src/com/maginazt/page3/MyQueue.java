package com.maginazt.page3;

import java.util.LinkedList;

/**
 * Created by zhaotao on 16/9/25.
 */
public class MyQueue {

    private LinkedList<Integer> inStack;
    private LinkedList<Integer> outStack;

    public MyQueue(){
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(outStack.isEmpty())
            dump();
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(outStack.isEmpty())
            dump();
        return outStack.peek();
    }

    private void dump() {
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        queue.push(4);
        queue.pop();
        queue.pop();
        System.out.println(queue.peek());
    }
}
