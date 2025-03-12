package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import java.util.*;

public class BoundaryOfBTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> rights = new LinkedList<>();

        postOrder(root, true, true, result, rights);
        result.addAll(rights);

        return result;
    }

    private void postOrder(TreeNode node, boolean isLeft, boolean isRight, LinkedList<Integer> acc, LinkedList<Integer> rs) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                acc.add(node.val);
            } else if (isLeft && isRight) {
                acc.add(node.val);
                postOrder(node.left, true, false, acc, rs);
                postOrder(node.right, false, true, acc, rs);
            } else if (isLeft) {
                acc.add(node.val);
                if (node.left != null) {
                    postOrder(node.left, true, false, acc, rs);
                    postOrder(node.right, false, false, acc, rs);
                } else {
                    postOrder(node.right, true, false, acc, rs);
                }
            } else if (isRight) {
                rs.addFirst(node.val);
                if (node.right != null) {
                    postOrder(node.left, false, false, acc, rs);
                    postOrder(node.right, false, true, acc, rs);
                } else {
                    postOrder(node.left, false, true, acc, rs);
                }
            } else {
                postOrder(node.left, false, false, acc, rs);
                postOrder(node.right, false, false, acc, rs);
            }
        }
    }

    public static void main(String[] args) {
        BoundaryOfBTree o = new BoundaryOfBTree();
        TreeNode tree = TreeNode.tree(0, new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10});
        TreeNode.show(tree);
        System.out.println(o.boundaryOfBinaryTree(tree));
    }
}
