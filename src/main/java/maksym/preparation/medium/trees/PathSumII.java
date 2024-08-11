package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;
import maksym.preparation.util.Util;

import java.util.*;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPath(root, 0, targetSum, new LinkedList<>(), paths);
        return paths;
    }

    public void findPath(TreeNode tree, int curr, int target, Deque<Integer> deque, List<List<Integer>> paths) {
        if (tree != null) {
            curr += tree.val;
            if (curr == target && tree.left == null && tree.right == null) {
                deque.offer(tree.val);
                paths.add(new ArrayList<>(deque));
                deque.pollLast();
            } else {
                deque.offer(tree.val);
                findPath(tree.left, curr, target, deque, paths);
                findPath(tree.right, curr, target, deque, paths);
                deque.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        PathSumII instance = new PathSumII();
        //TreeNode tree = TreeNode.tree(0, new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1});
        TreeNode tree = TreeNode.tree(0, new Integer[]{-2,null,-3});
        TreeNode.show(tree);
        Util.show2dList(instance.pathSum(tree, -5));
    }
}
