package maksym.preparation.medium;

import maksym.preparation.util.TreeNode;

import static maksym.preparation.util.TreeNode.create;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode tree, int tail) {
        if (tree == null) return 0;
        else {
            tail = tail * 10 + tree.val;
            int total = sum(tree.left, tail) + sum(tree.right, tail);
            return total == 0 ? tail : total;
        }
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers instance = new SumRootToLeafNumbers();
        TreeNode tree = create(4, create(9, create(5), create(1)), create(0));
        System.out.println(instance.sumNumbers(tree));
    }
}
