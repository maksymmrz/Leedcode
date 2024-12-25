package maksym.preparation.hard;

import maksym.preparation.util.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

import static maksym.preparation.util.TreeNode.create;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        AtomicInteger maxPath = new AtomicInteger(Integer.MIN_VALUE);
        maxPath(root, maxPath);
        return maxPath.get();
    }

    public int maxPath(TreeNode root, AtomicInteger maxPath) {
        if (root == null) return 0;
        else {
            int left = maxPath(root.left, maxPath);
            int right = maxPath(root.right, maxPath);

            int branchSum = Math.max(Math.max(left, right), 0) + root.val;

            int circle = left + root.val + right;
            int sum = Math.max(branchSum, circle);
            maxPath.set(Math.max(sum, maxPath.get()));

            return branchSum;
        }
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum instance = new BinaryTreeMaximumPathSum();
        TreeNode tree = create(-10, create(9), create(10, create(25), create(7)));
        TreeNode.show(tree);
        System.out.println(instance.maxPathSum(tree));
    }
}
