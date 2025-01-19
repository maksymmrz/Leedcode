package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

import java.util.*;

public class NodesDistanceKInBinaryTree {
    private final Map<TreeNode, TreeNode> ancestors = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addAncestors(root, ancestors);
        List<Integer> result = new ArrayList<>();
        findNeighbors(target, k, result, new HashSet<>());
        return result;
    }

    private void findNeighbors(TreeNode node, int k, List<Integer> result, Set<TreeNode> visited) {
        if (node != null && visited.add(node)) {
            if (k == 0) {
                result.add(node.val);
            } else {
                findNeighbors(node.left, k - 1, result, visited);
                findNeighbors(node.right, k - 1, result, visited);
                findNeighbors(ancestors.get(node), k - 1, result, visited);
            }
        }
    }

    private void addAncestors(TreeNode tree, Map<TreeNode, TreeNode> ancestors) {
        if (tree != null) {
            if (tree.left != null) {
                ancestors.put(tree.left, tree);
                addAncestors(tree.left, ancestors);
            }
            if (tree.right != null) {
                ancestors.put(tree.right, tree);
                addAncestors(tree.right, ancestors);
            }
        }
    }

    public static void main(String[] args) {
        NodesDistanceKInBinaryTree o = new NodesDistanceKInBinaryTree();

        TreeNode tree = TreeNode.tree(0, new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode.show(tree);

        assert tree != null;
        System.out.println(o.distanceK(tree, tree.left, 2));
    }
}
