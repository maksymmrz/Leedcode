package maksym.preparation.medium.lists;

import maksym.preparation.util.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    public ListNode sort(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;
        else {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rightHead = slow.next;
            slow.next = null;
            ListNode leftSorted = sort(head);
            ListNode rightSorted = sort(rightHead);
            return merge(leftSorted, rightSorted);
        }
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left != null && right != null) {
            ListNode remained = left.val < right.val ? left : right;
            remained.next = left.val < right.val ? merge(left.next, right) : merge(left, right.next);
            return remained;
        } else if (left != null) return left;
        else return right;
    }

    public static void main(String[] args) {
        SortList instance = new SortList();
        ListNode list = ListNode.createSeq(new int[]{3, 2, 5, 4, 1});
        ListNode.show(instance.sortList(list));
    }
}
