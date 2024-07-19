package maksym.preparation.util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode create(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }
    public static TreeNode create(int val) {
        return new TreeNode(val);
    }

    public static void show(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (tree != null) queue.offer(tree);

        while (!queue.isEmpty()) {
            final int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }
}
