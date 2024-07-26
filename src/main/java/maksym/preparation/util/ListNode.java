package maksym.preparation.util;

public class ListNode {

    public static ListNode create(int[] arr) {
        ListNode list = null;
        ListNode tail = null;

        for (int i : arr) {
            if (list == null) {
                list = new ListNode(i);
                tail = list;
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        return list;
    }

    public static ListNode create(int n) {
        ListNode list = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {
            if (list == null) {
                list = new ListNode(i + 1);
                tail = list;
            } else {
                tail.next = new ListNode(i + 1);
                tail = tail.next;
            }
        }
        return list;
    }

    public static void show(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
