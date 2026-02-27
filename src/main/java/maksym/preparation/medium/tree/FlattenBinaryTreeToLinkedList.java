package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import static maksym.preparation.util.TreeNode.create;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode head) {
        if (head != null) {
            var left = head.left;
            var right = head.right;

            head.left = null;
            head.right = null;

            flatten(left);
            flatten(right);

            if (left != null) {
                var leftListTail = left;
                while (leftListTail.right != null) leftListTail = leftListTail.right;
                head.right = left;
                leftListTail.right = right;
            } else {
                head.right = right;
            }
        }
    }

    public static void main(String[] args) {
        var o = new FlattenBinaryTreeToLinkedList();
        var tree = create(1, create(2, create(4), create(5)), create(3, create(6), create(7)));
        TreeNode.show(tree);
        o.flatten(tree);
        TreeNode.show(tree);
    }
}
