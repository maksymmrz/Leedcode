package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        Map<Integer, List<TreeNode>> cache = new HashMap<>();
        cache.put(0, Collections.singletonList(null));
        cache.put(1, List.of(TreeNode.create(1)));

        for (int nn = 2; nn <= n; nn++) {
            List<TreeNode> trees = new ArrayList<>();

            for (int k = 0; k < nn; k++) {
                List<TreeNode> leftCombinations = cache.get(nn - k - 1);
                List<TreeNode> rightCombinations = cache.get(k);

                for (TreeNode leftCombination : leftCombinations) {
                    for (TreeNode rightCombination : rightCombinations) {
                        TreeNode node = TreeNode.create(1, leftCombination, rightCombination);
                        trees.add(copyMarked(node, new AtomicInteger(0)));
                    }
                }
            }
            cache.put(nn, trees);
        }
        return cache.get(n);
    }

    private TreeNode copyMarked(TreeNode tree, AtomicInteger index) {
        if (tree == null) return null;
        else {
            TreeNode left = copyMarked(tree.left, index);
            TreeNode copy = TreeNode.create(index.incrementAndGet(), left, null);
            copy.right = copyMarked(tree.right, index);
            return copy;
        }
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII instance = new UniqueBinarySearchTreesII();
        for (TreeNode tree : instance.generateTrees(3)) {
            TreeNode.show(tree);
            System.out.println();
        }
    }
}
