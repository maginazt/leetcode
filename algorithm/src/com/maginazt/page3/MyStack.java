package com.maginazt.page3;

import java.util.LinkedList;

/**
 * Created by zhaotao on 2016/9/19.
 */
public class MyStack {

    private LinkedList<Integer>[] queues;

    private int currentIndex;

    public MyStack(){
        queues = new LinkedList[2];
        queues[0] = new LinkedList<>();
        queues[1] = new LinkedList<>();
        currentIndex = 0;
    }

    // Push element x onto stack.
    public void push(int x) {
        queues[currentIndex].addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        prepare();
        queues[currentIndex].removeFirst();
    }

    private void prepare(){
        if(queues[currentIndex].isEmpty())
            currentIndex = (currentIndex+1)%2;
        int size = queues[currentIndex].size();
        int otherIndex = (currentIndex+1)%2;
        for(int i=0;i<size-1;i++){
            queues[otherIndex].addLast(queues[currentIndex].removeFirst());
        }
    }

    // Get the top element.
    public int top() {
        prepare();
        return queues[currentIndex].getFirst();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queues[0].isEmpty() && queues[1].isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
    }
}
