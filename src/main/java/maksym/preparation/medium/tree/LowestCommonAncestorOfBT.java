package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class LowestCommonAncestorOfBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        AtomicReference<TreeNode> res = new AtomicReference<>();
        findAncestor(root, p, q, res);
        return res.get();
    }

    private boolean findAncestor(TreeNode root, TreeNode p, TreeNode q, AtomicReference<TreeNode> res) {
        if (root != null) {
            boolean left = findAncestor(root.left, p, q, res);
            boolean right = findAncestor(root.right, p, q, res);
            boolean itself = Objects.equals(root, p) || Objects.equals(root, q);

            if (left && right || (itself && (left || right))) {
                res.set(root);
                return true;
            }

            return left || right || itself;

        }
        return false;
    }

    public static void main(String[] args) {
        var o = new LowestCommonAncestorOfBT();

        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16};
        TreeNode tree = TreeNode.tree(0, data);
        TreeNode.show(tree);

        assert tree != null;
        System.out.println(o.lowestCommonAncestor(tree, tree.left.right, tree.right.left));
    }
}
