package com.maginazt.page3;

import com.maginazt.common.ListNode;

/**
 * Created by zhaotao on 2016/9/28.
 */
public class Number237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
