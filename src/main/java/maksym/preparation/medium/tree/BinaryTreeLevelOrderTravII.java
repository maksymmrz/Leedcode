package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTravII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> layers = new ArrayList<>();
        rec(root, 0, layers);

        Collections.reverse(layers);
        return layers;
    }

    private void rec(TreeNode node, int depth, List<List<Integer>> layers) {
        if (node != null) {
            if (depth == layers.size()) {
                layers.add(new ArrayList<>());
            }

            layers.get(depth).add(node.val);

            rec(node.left, depth + 1, layers);
            rec(node.right, depth + 1, layers);
        }
    }

    public static void main(String[] args) {
        var o = new BinaryTreeLevelOrderTravII();
        var tree = TreeNode.tree(0, new Integer[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.show(tree);
        System.out.println(o.levelOrderBottom(tree));
    }
}
