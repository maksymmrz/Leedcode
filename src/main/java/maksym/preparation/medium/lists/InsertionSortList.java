package maksym.preparation.medium.lists;

import maksym.preparation.util.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
            ListNode sortedH = new ListNode(Integer.MIN_VALUE);

            while (head != null) {
                ListNode curr = sortedH;
                while (curr.next != null && curr.next.val < head.val) curr = curr.next;
                ListNode tmp = curr.next;
                ListNode headNext = head.next;
                curr.next = head;
                head.next = tmp;

                head = headNext;
            }
            return sortedH.next;
    }

    public static void main(String[] args) {
        InsertionSortList instance = new InsertionSortList();
        ListNode list = ListNode.createSeq(new int[]{7, 1, 6, 2, 5, 3, 4});
        ListNode.show(instance.insertionSortList(list));
    }
}
