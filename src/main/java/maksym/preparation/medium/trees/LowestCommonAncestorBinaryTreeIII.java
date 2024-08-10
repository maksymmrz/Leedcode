package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorBinaryTreeIII {

    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        return lowestCommonAncestorRec(p, q, new HashSet<>());
    }

    public TreeNode lowestCommonAncestorRec(TreeNode a, TreeNode b, Set<TreeNode> used) {
        if (a != null && !used.add(a)) {
            return a;
        }
        if (b != null && !used.add(b)) {
            return b;
        }
        if (a != null) a = a.parent;
        if (b != null) b = b.parent;
        return lowestCommonAncestorRec(a, b, used);
    }

    public static void main(String[] args) {
        LowestCommonAncestorBinaryTreeIII instance = new LowestCommonAncestorBinaryTreeIII();

        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16};
        TreeNode tree = TreeNode.tree(0, data);
        TreeNode.show(tree);
        System.out.println(instance.lowestCommonAncestor(tree.left.left.left, tree.left.right.right).val);

    }
}
