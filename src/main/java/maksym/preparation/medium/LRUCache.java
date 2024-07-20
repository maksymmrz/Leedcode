package maksym.preparation.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public Map<Integer, Node> map;
    public Node start;
    public Node end;
    public final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.start = new Node(-11, -11);
        this.end = new Node(-11, -11);
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            deleteNode(node);
            addToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            deleteNode(node);
            if (node.val != value) {
                map.remove(key);
                node = new Node(key, value);
                map.put(key, node);
            }
            addToHead(node);

        } else {
            if (map.size() == capacity) {
                Node removed = end.prev;
                map.remove(removed.key);
                deleteNode(removed);
            }
            Node added = new Node(key, value);
            map.put(key, added);
            addToHead(added);
        }
    }

    public void deleteNode(Node node) {
        Node left = node.prev;
        Node right = node.next;
        left.next = right;
        right.prev = left;
    }

    public void addToHead(Node node) {
        Node tail = start.next;
        start.next = node;
        node.prev = start;
        node.next = tail;
        tail.prev = node;
    }



    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(1));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));

    }
}
