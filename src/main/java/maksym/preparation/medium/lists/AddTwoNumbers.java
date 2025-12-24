package maksym.preparation.medium.lists;

import maksym.preparation.util.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var resultList = new ListNode(0);
        var currentNode = resultList;
        var remained = 0;

        while (l1 != null || l2 != null) {
            int firstDigit = 0;

            if (l1 != null) {
                firstDigit = l1.val;
                l1 = l1.next;
            }

            int secondDigit = 0;

            if (l2 != null) {
                secondDigit = l2.val;
                l2 = l2.next;
            }
            var added = firstDigit + secondDigit + remained;

            currentNode.next = new ListNode(added % 10);

            remained = added / 10;
            currentNode = currentNode.next;
        }

        if (remained != 0) {
            currentNode.next = new ListNode(remained);
        }

        return resultList.next;
    }

    public static void main(String[] args) {
        var first = new ListNode(9, new ListNode(9, new ListNode(9)));
        var second = new ListNode(0, new ListNode(0, new ListNode(1)));
        var sum = new AddTwoNumbers().addTwoNumbers(first, second);

        ListNode.show(sum);
    }
}
