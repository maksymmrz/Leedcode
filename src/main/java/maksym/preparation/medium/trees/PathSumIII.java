package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

import java.util.*;

import static maksym.preparation.util.TreeNode.create;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        return countTargetSums(root, 0, targetSum, new HashMap<>());
    }

    private int countTargetSums(TreeNode tree, long prefix, int target, Map<Long, Integer> cache) {
        if (tree == null) return 0;
        else {
            long sum = tree.val + prefix;

            int count = cache.getOrDefault(sum - target, 0);

            if (sum == target) count++;

            cache.put(sum, 1 + cache.getOrDefault(sum, 0));

            count += countTargetSums(tree.left, sum, target, cache);
            count += countTargetSums(tree.right, sum, target, cache);

            int freq = cache.get(sum);

            if (freq == 1) cache.remove(sum);
            else cache.put(sum, freq - 1);

            return count;
        }
    }

    public static void main(String[] args) {
        PathSumIII o = new PathSumIII();
        TreeNode tree =
                create(3,
                        create(2,
                                create(-1,
                                        create(3),
                                        create(4)
                                ),
                                create(1)
                        ),
                        create(-1,
                                create(3,
                                        create(-1,
                                                create(2),
                                                create(3)
                                        ),
                                        create(1)
                                ),
                                create(4,
                                        create(2),
                                        create(3)
                                )
                        )
                );
        TreeNode.show(tree);
        System.out.println(o.pathSum(tree, 5));
    }
}
