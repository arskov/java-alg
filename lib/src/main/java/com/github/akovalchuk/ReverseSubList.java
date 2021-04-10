package com.github.akovalchuk;

/**
 * Educative.io Reverse a Sub-list (medium)
 * 
 * Leetcode. 92. Reverse Linked List II
 */
public class ReverseSubList {

    public static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || (left > right))
            return head;
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        int counter = 1;
        while (counter != left) {
            prev = curr;
            curr = curr.next;
            counter++;
        }
        ListNode preLeft = prev;
        ListNode nextTail = curr;
        prev = null;
        while (counter - 1 != right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter++;
        }
        if (preLeft != null)
            preLeft.next = prev;
        else
            head = prev;
        nextTail.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();
    }

}
