package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;
import maksym.preparation.util.Util;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        Queue<Map.Entry<Integer, TreeNode>> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(Map.entry(1000, root));
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Map.Entry<Integer, TreeNode> entry = queue.poll();
                int idx = entry.getKey();
                TreeNode tree = entry.getValue();

                result.computeIfAbsent(idx, k -> new ArrayList<>()).add(tree.val);

                if (tree.left != null) {
                    queue.offer(Map.entry(idx - 1, tree.left));
                }
                if (tree.right != null) {
                    queue.offer(Map.entry(idx + 1, tree.right));
                }
            }
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal instance = new BinaryTreeVerticalOrderTraversal();

        TreeNode tree = TreeNode.create(1, TreeNode.create(2), TreeNode.create(3));
        tree.left.left = TreeNode.create(4);
        tree.left.right = TreeNode.create(5);

        tree.right.left = TreeNode.create(6);
        tree.right.right = TreeNode.create(7);

        tree.right.right.left = TreeNode.create(8);
        tree.left.right.left = TreeNode.create(9);

        TreeNode.show(tree);

        List<List<Integer>> traverse = instance.verticalOrder(tree);
        Util.show2dList(traverse);
    }
}
