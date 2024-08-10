package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;
import maksym.preparation.util.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();
        if (root != null) queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.poll();
                level.add(tree.val);
                if (tree.left != null) queue.offer(tree.left);
                if (tree.right != null) queue.offer(tree.right);
            }
            levels.add(level);
        }
        return levels;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal instance = new BinaryTreeLevelOrderTraversal();
        TreeNode tree = TreeNode.tree(0, new Integer[]{1,2,3,4,5,6,7});
        TreeNode.show(tree);
        Util.show2dList(instance.levelOrder(tree));
    }
}
