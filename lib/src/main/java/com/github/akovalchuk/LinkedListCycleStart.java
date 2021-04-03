package com.github.akovalchuk;

/**
 * Educative.io. Start of LinkedList Cycle (medium)
 * 
 * 142. Linked List Cycle II
 */
public class LinkedListCycleStart {
    static class ListNode {
        int value;
        ListNode next;

        ListNode(int x) {
            value = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null)
                return null;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        int cycleLen = 1;
        ListNode node = slow;
        while (node != slow.next) {
            slow = slow.next;
            cycleLen++;
        }
        slow = head;
        fast = head;
        while (cycleLen > 0) {
            slow = slow.next;
            cycleLen--;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.detectCycle(head).value); // LinkedList
                                                                                                       // cycle start: 3

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.detectCycle(head).value); // LinkedList
                                                                                                       // cycle start: 4

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.detectCycle(head).value); // LinkedList
                                                                                                       // cycle start: 1

    }
}
