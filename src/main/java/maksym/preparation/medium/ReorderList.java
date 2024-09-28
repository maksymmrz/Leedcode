package maksym.preparation.medium;

import maksym.preparation.util.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode reversed = reverse(tailHalf(head), null);
        ListNode list = head;
        while (reversed != null) {
            ListNode nextFirst = list.next;
            list.next = reversed;
            ListNode nextReversed = reversed.next;
            reversed.next = nextFirst;
            reversed = nextReversed;
            list = nextFirst;
        }
    }

    public ListNode tailHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            ListNode tmp = slow;
            slow = slow.next;
            if (fast == null) tmp.next = null;
        }
        return slow;
    }

    public ListNode reverse(ListNode head, ListNode list) {
        if (head == null) return list;
        else {
            ListNode tail = head.next;
            head.next = list;
            return reverse(tail, head);
        }
    }

    public static void main(String[] args) {
        ReorderList instance = new ReorderList();
        ListNode list = ListNode.createSeq(4);
        instance.reorderList(list);
        ListNode.show(list);
    }
}
