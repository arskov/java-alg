package com.github.akovalchuk;

/**
 * Leetcode. 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    public static void main(String[] args) {
        var sol = new MergeTwoSortedLists();
        var list1 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7))));
        var list2 = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8))));
        var res = sol.mergeTwoLists(list1, list2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    
}
