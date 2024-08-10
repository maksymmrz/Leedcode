package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return gen(n, new HashMap<>())
                .stream()
                .map(tree -> markedCopy(tree, new AtomicInteger()))
                .collect(Collectors.toList());
    }

    public List<TreeNode> gen(int n, Map<Integer, List<TreeNode>> cache) {
        if (n == 0) return Collections.emptyList();
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else if (n == 1) {
            return Collections.singletonList(new TreeNode(1));
        } else {
            List<TreeNode> combinations = new ArrayList<>();

            for (int k = 0; k < n; k++) {
                int leftN = n - 1 - k;
                int rightN = k;
                List<TreeNode> combinationsL = gen(leftN, cache);
                List<TreeNode> combinationsR = gen(rightN, cache);

                if (combinationsL.isEmpty()) {
                    for (TreeNode right : combinationsR) {
                        combinations.add(new TreeNode(1, null, right));
                    }
                }
                if (combinationsR.isEmpty()) {
                    for (TreeNode left : combinationsL) {
                        combinations.add(new TreeNode(1, left, null));
                    }
                }
                for (TreeNode right : combinationsR) {
                    for (TreeNode left : combinationsL) {
                        combinations.add(new TreeNode(1, left, right));
                    }
                }
            }
            cache.put(n, combinations);
            return combinations;
        }

    }

    public TreeNode markedCopy(TreeNode tree, AtomicInteger num) {
        if (tree == null) return null;
        else {
            TreeNode left = markedCopy(tree.left, num);
            TreeNode node = new TreeNode(num.incrementAndGet(), left, null);
            node.right = markedCopy(tree.right, num);
            return node;
        }
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII instance = new UniqueBinarySearchTreesII();
        for (TreeNode tree : instance.generateTrees(4)) {
            TreeNode.show(tree);
            System.out.println();
        }
    }
}
