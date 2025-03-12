package maksym.preparation.medium.tree;

public class PopulatingNextRightPointersInEachNode {
    public static class ModNode {
        public int val;
        public ModNode left;
        public ModNode right;
        public ModNode next;

        public ModNode(int _val) {
            val = _val;
        }

        public ModNode(int _val, ModNode _left, ModNode _right, ModNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public ModNode connect(ModNode root) {
        if (root == null) return null;

        connect(root.left);
        connect(root.right);

        int depth = 0;
        ModNode left = right(root.left, depth);
        ModNode right = left(root.right, depth);

        while (left != null && right != null) {
            left.next = right;
            depth++;
            left = right(root.left, depth);
            right = left(root.right, depth);
        }
        return root;
    }

    public ModNode right(ModNode tree, int n) {
        if (tree == null) return null;
        else if (n == 0) return tree;
        else {
            ModNode result = right(tree.right, n - 1);
            if (result == null) result = right(tree.left, n - 1);
            return result;
        }
    }
    public ModNode left(ModNode tree, int n) {
        if (tree == null) return null;
        else if (n == 0) return tree;
        else {
            ModNode result = left(tree.left, n - 1);
            if (result == null) result = left(tree.right, n - 1);
            return result;
        }
    }
}
