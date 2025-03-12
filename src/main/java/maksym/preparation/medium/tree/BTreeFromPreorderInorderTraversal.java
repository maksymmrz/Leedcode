package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

public class BTreeFromPreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int i, int[] inorder, int l, int r) {
        if (l > r) return null;
        else if (l == r) return new TreeNode(inorder[l]);
        else {
            int j = l;
            while (j <= r && inorder[j] != preorder[i]) j++;
            TreeNode left = null;
            int next = i + (j - l);
            if (next != i) {
                left = build(preorder, i + 1, inorder, l, j - 1);
            }
            TreeNode right = null;
            if (r - j > 0) {
                right = build(preorder, next + 1, inorder, j + 1, r);
            }
            return new TreeNode(preorder[i], left, right);
        }
    }

    public static void main(String[] args) {
        BTreeFromPreorderInorderTraversal instance = new BTreeFromPreorderInorderTraversal();
        //TreeNode tree = instance.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode tree = instance.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        TreeNode.show(tree);
    }
}
