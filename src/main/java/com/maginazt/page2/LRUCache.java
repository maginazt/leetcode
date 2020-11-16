package com.maginazt.page2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaotao on 2016/8/30.
 */
public class LRUCache {

    private static class Node{
        int key;
        int value;
        Node next;
        Node prev;

        Node(Node prev, int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    //head.prev always point to the tail
    private Node head;
    private int capacity;
    private int size;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        head = new Node(null, -1, -1, null);
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            move2First(node);
            return node.value;
        }
        else
            return -1;
    }

    private void move2First(Node node) {
        if(head.next == node)
            return;
        node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
        else{
            head.prev = node.prev;
        }
        node.next = head.next;
        if(head.next != null)
            head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void set(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            move2First(node);
        }
        else{
            Node node;
            //create new node
            if(size < capacity){
                ++size;
                node = new Node(null, key, value, null);
                insertFirst(node);
            }
            //reuse the last one
            else{
                node = head.prev;
                cache.remove(node.key);
                node.key = key;
                node.value = value;
                move2First(node);
            }
            cache.put(key, node);
        }
    }

    private void insertFirst(Node node) {
        node.next = head.next;
        if(head.next != null)
            head.next.prev = node;
        head.next = node;
        node.prev = head;
        if(head.prev == null)
            head.prev = node;
    }

    private void print(){
        Node c = head.next;
        while (c != null){
            System.out.print(c.value+", ");
            c = c.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(4);
        int[] keys = {1,2,3,4,2,1,5,6,2,1,2,3,7,6,3,2,1,2,3,6};
        for(int key : keys){
            if(c.get(key) == -1)
                c.set(key, key);
        }
        c.print();
    }
}
