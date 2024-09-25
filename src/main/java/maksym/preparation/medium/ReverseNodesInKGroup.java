package maksym.preparation.medium;

import maksym.preparation.util.ListNode;


public class ReverseNodesInKGroup {

    public static ListNode ln(int val, ListNode node) {
        return new ListNode(val, node);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = null;
        ListNode finish = null;

        while (head != null) {
            ListNode top = null;
            ListNode tail = head;

            int remainCount = 0;
            ListNode pointer = head;
            while (pointer != null && remainCount < k) {
                remainCount++;
                pointer = pointer.next;
            }

            if (remainCount == k) {
                for (int i = 0; i < k; i++) {
                    ListNode curr = head;
                    head = head.next;
                    curr.next = top;
                    top = curr;
                }
            } else {
                top = head;
                head = head.next;
            }

            if (start == null) {
                start = top;
                finish = tail;
            } else {
                finish.next = top;
                finish = tail;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        ListNode list = ln(1, null);
        ListNode tail = list;
        for (int i = 2; i < 18; i++) {
            tail.next = ln(i, null);
            tail = tail.next;
        }
        ListNode reversed = new ReverseNodesInKGroup().reverseKGroup(list, 5);
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
}
