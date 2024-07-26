package maksym.preparation.medium;

import maksym.preparation.util.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = null;
        ListNode end = null;
        ListNode current = head;

        while (current != null) {
            while (current != null && current.next != null && current.next.val == current.val) {
                int val = current.val;
                while (current != null && current.val == val) current = current.next;
            }
            if (end == null) {
                start = current;
                end = current;
            } else {
                end.next = current;
                end = end.next;
            }
            if (current != null) {
                current = current.next;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII instance = new RemoveDuplicatesFromSortedListII();
        ListNode list = ListNode.create(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode.show(list);
        ListNode.show(instance.deleteDuplicates(list));
    }


}
