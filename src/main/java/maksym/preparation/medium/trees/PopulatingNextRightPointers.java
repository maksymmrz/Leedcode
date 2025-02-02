package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

public class PopulatingNextRightPointers {
    public TreeNode connect(TreeNode root) {
        recConnect(root);
        return root;
    }

    private void recConnect(TreeNode tree) {
        if (tree != null) {
            TreeNode parentNext = tree.next;
            TreeNode childNext = null;

            if (parentNext != null) {
                childNext = parentNext.left != null ? parentNext.left : parentNext.right;
            }

            if (tree.left != null && tree.right != null) {
                tree.left.next = tree.right;
                tree.right.next = childNext;
            } else if (tree.left != null) {
                tree.left.next = childNext;
            } else if (tree.right != null){
                tree.right.next = childNext;
            }

            recConnect(tree.left);
            recConnect(tree.right);
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointers o = new PopulatingNextRightPointers();
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
