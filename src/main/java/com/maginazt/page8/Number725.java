package com.maginazt.page8;

import com.maginazt.structure.ListNode;

import java.util.Arrays;

/**
 * @author: zhaotao
 * @date: 2020/11/23 17:21
 */
public class Number725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) {
            return result;
        }
        int size = getSize(root);
        int avg = size / k;
        int remain = size % k;
        int index = 0;
        ListNode cur = root;
        ListNode pre = null;
        ListNode prevRoot = null;
        while (cur != null) {
            prevRoot = cur;
            int move = avg;
            if (remain > 0) {
                move += 1;
                --remain;
            }
            while (move > 0) {
                pre = cur;
                cur = cur.next;
                --move;
            }
            result[index++] = prevRoot;
            pre.next = null;
        }
        return result;
    }

    private int getSize(ListNode p) {
        int size = 0;
        while (p != null) {
            ++size;
            p = p.next;
        }
        return size;
    }

    public static void main(String[] args) {
        Number725 number725 = new Number725();
        System.out.println(Arrays.toString(number725.splitListToParts(ListNode.create(Arrays.asList(1, 2, 3)), 5)));
        System.out.println(Arrays.toString(number725.splitListToParts(ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)), 3)));
    }
}
