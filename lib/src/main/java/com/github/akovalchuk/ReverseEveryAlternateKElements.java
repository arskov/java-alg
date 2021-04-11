package com.github.akovalchuk;

/**
 * Educative.io. Reverse alternating K-element Sub-list (medium)
 * 
 * 
 */
public class ReverseEveryAlternateKElements {

    private static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
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

    public static ListNode reverse(ListNode head, int k) {
        if (head == null || k < 0)
            return head;
        ListNode newHead = null;
        ListNode prev = null;
        ListNode curr = head;
        int counter = 0;
        while (curr != null) {
            if (counter % (k * 2) == 0) {
                ListNode subHead = reverseSubList(curr, k);
                if (newHead == null) {
                    newHead = subHead;
                }
                if (prev != null) prev.next = subHead;
                prev = curr;
                curr = curr.next;
                counter += 2;
            } else {
                counter++;
                prev = curr;
                curr = curr.next;
            }
         }
        return newHead;
    }

    private static ListNode reverseSubList(ListNode head, int k) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (k > 0 && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        if (curr != null) {
            head.next = curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        System.out.println(head);
        ListNode result = reverse(head, 2);
        System.out.println(result);
    }
}
