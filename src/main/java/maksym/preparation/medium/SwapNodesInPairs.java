package maksym.preparation.medium;

import maksym.preparation.util.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode start = null;
        ListNode tail = null;

        while (head != null) {
            ListNode second = head;
            ListNode first = head.next;

            if (head.next != null) {
                head = head.next.next;
                first.next = second;
                second.next = null;
            } else {
                head = head.next;
            }

            if (start == null) {
                start = first != null ? first : second;
                tail = second;
            } else {
                tail.next = first != null ? first : second;
                tail = second;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        ListNode ordered = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode swaped = new SwapNodesInPairs().swapPairs(ordered);
        while (swaped != null) {
            System.out.println(swaped.val);
            swaped = swaped.next;
        }
    }
}
