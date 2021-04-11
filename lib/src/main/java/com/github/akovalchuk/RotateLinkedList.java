package com.github.akovalchuk;

/**
 * Educative.io Rotate a LinkedList
 * 
 * Leetcode. 61. Rotate List
 */
public class RotateLinkedList {

    public static class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public String toString() {
            var sb = new StringBuilder();
            var curr = this;
            sb.append("[");
            while (curr != null) {
                sb.append(curr.value).append(" -> ");
                curr = curr.next;
            }
            sb.setLength(sb.length() - 4);
            sb.append("]");
            return sb.toString();
        }
    }

    public static ListNode rotate(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode last = null;
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            last = curr;
            curr = curr.next;
            size++;
        }
        k = k % size;
        if (k == 0)
            return head;
        int pos = size - k;
        ListNode prev = null;
        curr = head;
        while (pos > 0) {
            prev = curr;
            curr = curr.next;
            pos--;
        }
        last.next = head;
        head = curr;
        if (prev != null)
            prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(head);
        System.out.println(rotate(head, 2));
    }
}
