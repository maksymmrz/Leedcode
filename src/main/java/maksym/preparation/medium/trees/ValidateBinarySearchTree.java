package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

public class ValidateBinarySearchTree {
    public static class NodeInfo {
        public NodeInfo(boolean isCorrect, int max, int min) {
            this.isCorrect = isCorrect;
            this.max = max;
            this.min = min;
        }
        public boolean isCorrect;
        public int max;
        public int min;
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root).isCorrect;
    }

    public NodeInfo validate(TreeNode tree) {
        if (tree == null) return new NodeInfo(true, -1, -1);
        else if (tree.left == null && tree.right == null) return new NodeInfo(true, tree.val, tree.val);
        else if (tree.left == null) {
            NodeInfo right = validate(tree.right);
            boolean isValid = right.isCorrect && tree.val < right.min;
            return new NodeInfo(isValid, right.max, tree.val);
        } else if (tree.right == null) {
            NodeInfo left = validate(tree.left);
            boolean isValid = left.isCorrect && left.max < tree.val;
            return new NodeInfo(isValid, tree.val, left.min);
        } else {
            NodeInfo left = validate(tree.left);
            NodeInfo right = validate(tree.right);
            boolean isValidLeft = left.isCorrect && left.max < tree.val;
            boolean isValidRight = right.isCorrect && tree.val < right.min;
            return new NodeInfo(isValidLeft && isValidRight, right.max, left.min);
        }
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree instance = new ValidateBinarySearchTree();

        TreeNode tree1 = TreeNode.tree(0, new Integer[]{5, 1, 4, null, null, 3, 6});
        System.out.println(instance.isValidBST(tree1));

        TreeNode tree2 = TreeNode.tree(0, new Integer[]{5,4,6,null,null,3,7});
        System.out.println(instance.isValidBST(tree2));
    }
}
