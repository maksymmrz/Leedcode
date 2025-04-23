package maksym.preparation.medium.lists;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Node copyRandomList(Node head) {
        Map<Node, Node> copies = new HashMap<>();
        Node copyH = new Node(0);
        Node curr = copyH;
        while (head != null) {
            curr.next = new Node(head.val);
            curr = curr.next;
            curr.random = head.random;
            copies.put(head, curr);
            head = head.next;
        }
        curr = copyH.next;
        while (curr != null) {
            curr.random = copies.get(curr.random);
            curr = curr.next;
        }
        return copyH.next;
    }

    public static void main(String[] args) {
        CopyListRandomPointer instance = new CopyListRandomPointer();
        Node start = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(11);
        start.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = start;
        node2.random = node4;
        node3.random = node2;
        node4.random = start;
        Node copy = instance.copyRandomList(start);
        while (copy != null) {
            System.out.println(copy.val);
            copy = copy.next;
        }
    }
}
