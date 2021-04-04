package com.github.akovalchuk;

/**
 * Educative.io. Rearrange a LinkedList (medium)
 * 
 * 143. Reorder List
 */
public class RearrangeLinkedList {
    
    static class ListNode {

        static int nodeCounter = 1;

        int counter;
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.counter = nodeCounter++;
        }

        public String toString() {
            var sb = new StringBuilder();
            ListNode tmp = this;
            while (tmp != null) {
                sb.append(tmp.value).append(" (").append(tmp.counter).append(")").append(" -> ");
                tmp = tmp.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }

    public static void reorder(ListNode head) {
        // System.out.println(head);
        if (head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        prev = null;
        // System.out.println();
        // System.out.println(head);
        // System.out.println(slow);
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        // System.out.println();
        // System.out.println(head);
        // System.out.println(prev);
        ListNode l1 = head;
        ListNode l2 = prev;
        while (l1.next != null) {
            ListNode tmp = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = tmp;
            l1 = tmp;
        }
        l1.next = l2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next = new ListNode(1);
        reorder(head);
        System.out.println(head);
        System.out.println("---");

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        reorder(head);
        System.out.println(head);
        System.out.println("---");
    }

}
