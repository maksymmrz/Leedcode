package maksym.preparation.medium;

import maksym.preparation.util.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        if (len == k || head == null) return head;

        k %= len;

        ListNode end = head;
        for (int i = 0; i < len - k - 1; i++) {
            end = end.next;
        }
        ListNode tail = end.next;
        end.next = null;

        if (tail != null) {
            ListNode rotated = tail;
            while (tail.next != null) tail = tail.next;
            tail.next = head;
            return rotated;

        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        RotateList instance = new RotateList();

        ListNode list = ListNode.create(4);
        ListNode.show(list);
        ListNode.show(instance.rotateRight(list, 5));
    }
}
