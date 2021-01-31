package com.github.akovalchuk;

import java.util.Stack;

public class ReorderLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        var mid = middle(head);
        var rev = reverse(mid);
        merge(head, rev);
    }
    
    private void merge(ListNode a, ListNode b) {
        var left = a;
        var right = b;
        while (left != null && right != null) {
            var tmp1 = left.next;
            var tmp2 = right.next;
            left.next = right;
            left.next.next = tmp1;
            left = left.next.next;
            right = tmp2;
        }
    }
    
    private ListNode middle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                fast = null;
        }
        prev.next = null;
        return slow;
    }
    
    private ListNode reverse(ListNode node) {
        var stack = new Stack<ListNode>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        var revHead = stack.pop();
        node = revHead;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return revHead;
    }

    public static void main(String[] args) {
        var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        var solution = new ReorderLinkedList();
        solution.reorderList(list);
        ListNode node = list;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
