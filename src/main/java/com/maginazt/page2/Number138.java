package com.maginazt.page2;

import com.maginazt.structure.RandomListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by zhaotao on 2016/8/29.
 */
public class Number138 {

    private static final Map<RandomListNode, RandomListNode> cache = new HashMap<>();
    private static final LinkedList<RandomListNode> queue = new LinkedList<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        cache.clear();
        queue.clear();
        RandomListNode newHead = new RandomListNode(head.label);
        cache.put(head, newHead);
        queue.addLast(head);
        while (!queue.isEmpty()){
            RandomListNode oldNode = queue.removeFirst();
            RandomListNode newNode = cache.get(oldNode);
            if(oldNode.next != null){
                RandomListNode oldNext = oldNode.next;
                if(cache.containsKey(oldNext))
                    newNode.next = cache.get(oldNext);
                else{
                    RandomListNode newNext = new RandomListNode(oldNext.label);
                    newNode.next = newNext;
                    cache.put(oldNext, newNext);
                    queue.addLast(oldNext);
                }
            }
            if(oldNode.random != null){
                RandomListNode oldRandom = oldNode.random;
                if(cache.containsKey(oldRandom))
                    newNode.random = cache.get(oldRandom);
                else{
                    RandomListNode newRandom = new RandomListNode(oldRandom.label);
                    newNode.random = newRandom;
                    cache.put(oldRandom, newRandom);
                    queue.addLast(oldRandom);
                }
            }
        }
        return newHead;
    }
}
