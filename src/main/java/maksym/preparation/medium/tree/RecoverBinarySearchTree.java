package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import static maksym.preparation.util.TreeNode.create;

public class RecoverBinarySearchTree {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void inorder(TreeNode tree) {
        if (tree != null) {
            inorder(tree.left);

            if (prev != null && tree.val < prev.val) {
                if (first == null) first = prev;
                second = tree;
            }
            prev = tree;
            inorder(tree.right);
        }
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree instance = new RecoverBinarySearchTree();
        TreeNode tree = create(1, create(3, null, null), create(2));
        TreeNode.show(tree);
        instance.recoverTree(tree);
        TreeNode.show(tree);
    }
}
