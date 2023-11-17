package main.java.person.maksym.preparation;

import java.util.*;

public class MergeKSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode merge(ListNode first, ListNode second) {
        if (first == null) return second;
        if (second == null) return first;

        if (first.val < second.val) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }

    private ListNode sort(ListNode[] arr, int from, int to) {
        if (from == to) {
            return arr[from];
        } else {
            int mid = (to + from) / 2;
            ListNode first = sort(arr, from, mid);
            ListNode second = sort(arr, mid + 1, to);
            return merge(first, second);
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length != 0) {
            return sort(lists, 0, lists.length - 1);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        ListNode result = new MergeKSortedLists().mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
