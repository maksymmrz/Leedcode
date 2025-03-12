package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import java.util.Map;

import static maksym.preparation.util.TreeNode.create;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        Map.Entry<Integer, Integer> res = robRec(root);
        return Math.max(res.getKey(), res.getValue());
    }

    private Map.Entry<Integer, Integer> robRec(TreeNode root) {
        if (root == null) return Map.entry(0 , 0);
        else {
            Map.Entry<Integer, Integer> left = robRec(root.left);
            Map.Entry<Integer, Integer> right = robRec(root.right);
            int include = root.val + left.getValue() + right.getValue();
            int exclude = Math.max(left.getKey(), left.getValue()) + Math.max(right.getKey(), right.getValue());

            return Map.entry(include, exclude);
        }
    }

    public static void main(String[] args) {
        HouseRobberIII o = new HouseRobberIII();
        TreeNode tree = create(
                3,
                create(2, null, create(3)),
                create(1, create(1), null));
        System.out.println(o.rob(tree));
    }
}
