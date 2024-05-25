package maksym.preparation.medium;

public class RemoveNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        int len = 0;
        ListNode p = head;

        while (p != null) {
            p = p.next;
            len++;
        }
        int pos = len - n;

        if (pos == 0) {
            return head.next;
        } else {
            p = head;
            for (int i = 1; i < pos; i++) {
                p = p.next;
            }

            ListNode split = p.next;
            p.next = split.next;

            return head;
        }
    }

    public static void main(String[] args) {
        ListNode list = null;
        ListNode curr = null;
        final int len = 11;
        for (int i = 0; i < len; i++) {
            if (curr == null) {
                 list = new ListNode(i + 1, null);
                 curr = list;
            } else {
                curr.next = new ListNode(i + 1, null);
                curr = curr.next;
            }
        }

        ListNode cut = new RemoveNodeFromEndOfList().removeNthFromEnd(list, 11);

        for (int i = 0; i < len - 1; i++) {
            System.out.println(cut.val);
            cut = cut.next;
        }
    }
}
