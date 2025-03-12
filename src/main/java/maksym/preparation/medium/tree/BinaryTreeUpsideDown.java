package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import static maksym.preparation.util.TreeNode.create;

public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root != null && root.left != null) {
            TreeNode down = upsideDownBinaryTree(root.left);

            root.left.right = root;
            root.left.left = root.right;

            root.left = null;
            root.right = null;

            return down;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeUpsideDown instance = new BinaryTreeUpsideDown();
        TreeNode tree = create(1, create(2, create(4), create(5)), create(3));
        TreeNode.show(tree);
        TreeNode.show(instance.upsideDownBinaryTree(tree));
    }
}
