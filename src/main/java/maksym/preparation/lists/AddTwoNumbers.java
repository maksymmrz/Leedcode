package maksym.preparation.lists;

public class AddTwoNumbers {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int nextOne = 0;
        ListNode first = l1;
        ListNode second = l2;

        while (first != null || second != null) {
            int sum;
            if (first != null && second != null) {
                sum = first.val + second.val;
                first = first.next;
                second = second.next;
            } else if (first != null) {
                sum = first.val;
                first = first.next;
            } else {
                sum = second.val;
                second = second.next;
            }

            int value = (sum + nextOne) % 10;
            ListNode next = new ListNode(value);
            nextOne = (sum + nextOne) / 10;

            if (tail == null) {
                head = next;
            } else {
                tail.next = next;
            }
            tail = next;
        }
        if (nextOne != 0) {
            tail.next = new ListNode(nextOne);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode second = new ListNode(0, new ListNode(0, new ListNode(1)));
        ListNode sum = new AddTwoNumbers().addTwoNumbers(first, second);
        while (sum != null) {
            System.out.print(sum.val);
            sum = sum.next;
        }
    }
}
