package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

public class LowestCommonAncestorBinaryTreeIII {

    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        int ph = lenToTop(p);
        int qh = lenToTop(q);
        int diff = Math.abs(ph - qh);

        if (ph < qh) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }

        for (int i = 0; i < diff; i++) {
            p = p.parent;
        }

        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    public int lenToTop(TreeNode node) {
        int l = 0;
        while (node != null) {
            l++;
            node = node.parent;
        }
        return l;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBinaryTreeIII instance = new LowestCommonAncestorBinaryTreeIII();

        Integer[] data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16};
        TreeNode tree = TreeNode.tree(0, data);
        TreeNode.show(tree);
        System.out.println(instance.lowestCommonAncestor(tree.left.left.left, tree.left.right.right).val);

    }
}
