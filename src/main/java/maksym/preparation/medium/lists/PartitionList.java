package maksym.preparation.medium.lists;

import maksym.preparation.util.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode greaterHead = new ListNode(Integer.MIN_VALUE);
        ListNode greaterEnd = greaterHead;

        ListNode smallerHead = new ListNode(Integer.MIN_VALUE);
        ListNode smallerEnd = smallerHead;

        while (head != null) {
            int val = head.val;

            if (val < x) {
                smallerEnd.next = new ListNode(val);
                smallerEnd = smallerEnd.next;
            } else {
                greaterEnd.next = new ListNode(val);
                greaterEnd = greaterEnd.next;
            }
            head = head.next;
        }
        smallerEnd.next = greaterHead.next;
        return smallerHead.next;
    }

    public static void main(String[] args) {
        PartitionList instance = new PartitionList();
        ListNode list = ListNode.createSeq(new int[]{1,4,3,2,5,2});
        ListNode.show(instance.partition(list, 3));
    }
}
