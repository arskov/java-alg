package com.github.akovalchuk;

/**
 * Educative.io. Palindrome LinkedList (medium)
 * 
 * Leetcode. 234. Palindrome Linked List
 */
public class PalindromicLinkedList {

    public static class ListNode {

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

    public static boolean isPalindrome(ListNode head) {
        ListNode.nodeCounter = 1;
        ListNode tmp = null;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isEven = true;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            tmp = slow;
            slow = slow.next;
            tmp.next = prev;
            prev = tmp;
        }
        if (fast != null)
            isEven = false;
        // System.out.println(prev);
        // System.out.println(slow);
        boolean isPal = true;
        ListNode left = prev;
        ListNode right = isEven ? slow : slow.next;
        prev = slow;
        while (left != null) {
            if (left.value != right.value)
                isPal = false;
            tmp = left;
            left = left.next;
            right = right.next;
            tmp.next = prev;
            prev = tmp;
        }
        // System.out.println(head);
        return isPal;
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
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next = new ListNode(1);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }

}
