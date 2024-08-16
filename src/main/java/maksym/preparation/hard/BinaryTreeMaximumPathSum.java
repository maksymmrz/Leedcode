package maksym.preparation.hard;

import maksym.preparation.util.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

import static maksym.preparation.util.TreeNode.create;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        AtomicInteger result = new AtomicInteger(Integer.MIN_VALUE);
        maxPath(root, result);
        return result.get();
    }

    public int maxPath(TreeNode tree, AtomicInteger max) {
        if (tree == null) return 0;
        else {
            int left = maxPath(tree.left, max);
            int right = maxPath(tree.right, max);
            int maxBranch = Math.max(left, right);
            int circle = Math.max(tree.val, tree.val + left + right);
            max.set(Math.max(tree.val + maxBranch, Math.max(circle, max.get())));
            return tree.val + Math.max(0, maxBranch);
        }
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum instance = new BinaryTreeMaximumPathSum();
        TreeNode tree = create(-10, create(9), create(10, create(25), create(7)));
        TreeNode.show(tree);
        System.out.println(instance.maxPathSum(tree));
    }
}
