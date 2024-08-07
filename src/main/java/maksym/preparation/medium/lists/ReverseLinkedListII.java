package maksym.preparation.medium.lists;

import maksym.preparation.util.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode before = new ListNode(Integer.MIN_VALUE);
        before.next = head;
        ListNode node = before;
        for (int i = 1; i < left; i++) node = node.next;
        ListNode cut = node;

        node = node.next;
        ListNode reverce = null;
        ListNode tail = null;

        for (int i = left; i <= right; i++) {
            ListNode tmp = node;
            node = node.next;

            tmp.next = reverce;
            reverce = tmp;
            if (i == left) tail = reverce;
        }
        cut.next = reverce;
        if (tail != null) tail.next = node;
        return before.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII instance = new ReverseLinkedListII();
        ListNode list = ListNode.createSeq(9);
        ListNode.show(instance.reverseBetween(list, 1, 9));
    }
}
