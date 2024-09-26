package maksym.preparation.medium;

import maksym.preparation.util.ListNode;

import static maksym.preparation.util.ListNode.create;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = new ListNode(0, head);
        ListNode fast = slow.next;
        while (fast != null) {
            if (slow.equals(fast)) {
                slow = new ListNode(0, new ListNode(0, head));
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycleII instance = new LinkedListCycleII();
        ListNode circle = create(2);
        circle.next = create(3, create(4, circle));
        ListNode head = create(1, circle);
        System.out.println(instance.detectCycle(head).val);
    }
}
