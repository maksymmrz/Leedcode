package maksym.preparation.util;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode parent = null;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode create(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }

    public static TreeNode create(int val) {
        return new TreeNode(val);
    }

    public static TreeNode tree(int i, Integer[] nums) {
        if (i >= nums.length || nums[i] == null) return null;
        else {
            TreeNode left = tree(i * 2 + 1, nums);
            TreeNode right = tree(i * 2 + 2, nums);
            TreeNode node = new TreeNode(nums[i], left, right);
            if (left != null) {
                left.parent = node;
            }
            if (right != null) {
                right.parent = node;
            }
            return node;
        }
    }

    public static void show(TreeNode tree) {
        int depth = depth(tree);
        String[] layers = new String[depth];
        traverse(tree, depth - 1, layers);
        for (int i = layers.length - 1; i >= 0; i--) {
            System.out.println(layers[i]);
        }
        System.out.println();
    }

    private static void traverse(TreeNode tree, int i, String[] layers) {
        if (tree != null || i >= 0) {
            if (layers[i] == null) layers[i] = "   ".repeat((int) Math.pow(2, i));

            int width = (int) Math.pow(2, i) * 6;
            String val = tree == null ? "n" : String.valueOf(tree.val);
            layers[i] += String.format("%-" + width + "s", val);
            if (tree != null) {
                traverse(tree.left, i - 1, layers);
                traverse(tree.right, i - 1, layers);
            } else {
                traverse(null, i - 1, layers);
                traverse(null, i - 1, layers);
            }
        }
    }

    private static int depth(TreeNode tree) {
        if (tree == null) return 0;
        else return Math.max(depth(tree.left), depth(tree.right)) + 1;
    }
}
