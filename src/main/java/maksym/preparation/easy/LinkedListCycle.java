package maksym.preparation.easy;

import maksym.preparation.util.ListNode;

import static maksym.preparation.util.ListNode.create;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = new ListNode(0, head);
        ListNode fast = slow.next;
        while (fast != null) {
            if (slow.equals(fast)) return true;
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle instance = new LinkedListCycle();
        ListNode circle = create(4);
        circle.next = create(5, create(6, create(7, create(8, circle))));
        ListNode head = create(1, create(2, create(3, circle)));
        System.out.println(instance.hasCycle(head));
    }
}
