package maksym.preparation.easy;

import maksym.preparation.util.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        var curr = head;

        while (curr != null) {
            var next = curr.next;

            while (next != null && next.val == curr.val) {
                next = next.next;
            }

            curr.next = next;
            curr = next;
        }

        return head;
    }

    public static void main(String[] args) {
        var o = new RemoveDuplicatesFromSortedList();
        var list = ListNode.createSeq(new int[]{1, 1, 2, 2, 3, 4, 5, 5});

        list = o.deleteDuplicates(list);

        ListNode.show(list);
    }
}
