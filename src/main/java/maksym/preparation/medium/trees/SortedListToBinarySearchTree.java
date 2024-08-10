package maksym.preparation.medium.trees;

import maksym.preparation.util.ListNode;
import maksym.preparation.util.TreeNode;

public class SortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        TreeNode tree = emptyTree(size);
        setValues(tree, head);
        return tree;
    }

    public ListNode setValues(TreeNode tree, ListNode list) {
        if (tree != null) {
            ListNode tail = setValues(tree.left, list);
            tree.val = tail.val;
            return setValues(tree.right, tail.next);

        } else return list;
    }

    public TreeNode emptyTree(int n) {
        if (n <= 0) return null;
        else {
            TreeNode left = emptyTree(n / 2);
            TreeNode right = emptyTree(n - n / 2 - 1);
            return new TreeNode(1, left, right);
        }
    }

    public static void main(String[] args) {
        SortedListToBinarySearchTree instance = new SortedListToBinarySearchTree();
        ListNode list = ListNode.createSeq(7);
        TreeNode.show(instance.sortedListToBST(list));
    }
}
