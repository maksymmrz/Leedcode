package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

public class PopulatingNextRightPointersInEachNodeII {
    public TreeNode connect(TreeNode root) {
        if (root == null) return null;

        var next = root.next;
        var left = root.left;
        var right = root.right;

        if (left != null) {
            left.next = right;
        }

        var rootRightChild = root.right != null ? root.right : root.left;

        var nextLeftChild = nextChild(next);

        if (rootRightChild != null) {
            rootRightChild.next = nextLeftChild;
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private TreeNode nextChild(TreeNode node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII o = new PopulatingNextRightPointersInEachNodeII();
        TreeNode root = TreeNode.tree(0, new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.show(root);

        TreeNode resTree = o.connect(root);

        while (resTree != null) {
            TreeNode curr = resTree;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println();
            resTree = resTree.left != null ? resTree.left : resTree.right;
        }

    }
}
