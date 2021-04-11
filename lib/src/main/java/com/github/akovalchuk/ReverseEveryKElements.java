package com.github.akovalchuk;

/**
 * Educative.io. Reverse every K-element Sub-list (medium)
 * 
 * Leetcode. 25. Reverse Nodes in k-Group (the difference is to left last nodes if their
 * length is not greater then k)
 */
public class ReverseEveryKElements {

    public static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode reverse(ListNode head, int k) {
        ListNode lastOfPrevSegment = null;
        ListNode tailOfNewSegment = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (tailOfNewSegment != null) {
            int counter = k;
            prev = null;
            while (counter > 0 && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                counter--;
            }
            if (lastOfPrevSegment == null) {
                head = prev;
            } else {
                lastOfPrevSegment.next = prev;
            }
            lastOfPrevSegment = tailOfNewSegment;
            tailOfNewSegment = curr;
        }
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        int len = 0;
        ListNode tailOfPrevSeg = null;
        ListNode tailOfNewSeg = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        curr = head;
        while (len >= k) {
            prev = null;
            int counter = k;
            len -= k;
            while (counter > 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                counter--;
            }
            if (tailOfPrevSeg == null) {
                head = prev;
            } else {
                tailOfPrevSeg.next = prev;
            }
            tailOfPrevSeg = tailOfNewSeg;
            tailOfNewSeg = curr;
        }
        if (curr != null && tailOfPrevSeg != null) {
            tailOfPrevSeg.next = curr;
        }
        return head;
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

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        result = ReverseEveryKElements.reverseKGroup(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println();

    }
}
