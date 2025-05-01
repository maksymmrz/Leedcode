package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBTreeFromString {

    public TreeNode str2tree(String s) {
        return buildTree(s, new AtomicInteger(0));
    }

    private TreeNode buildTree(String s, AtomicInteger from) {
        if (from.get() == s.length()) {
            return null;
        } else {
            int n = scanInt(s, from);
            var node = new TreeNode(n);

            if (from.get() < s.length() && s.charAt(from.get()) == '(') {
                from.incrementAndGet();
                node.left = buildTree(s, from);
            }
            if (from.get() < s.length() && s.charAt(from.get()) == '(') {
                from.incrementAndGet();
                node.right = buildTree(s, from);
            }

            if (from.get() < s.length() && s.charAt(from.get()) == ')') {
                from.incrementAndGet();
            }

            return node;
        }
    }

    private int scanInt(String s, AtomicInteger from) {
        int i = from.get();

        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int n = 0;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            n *= 10;
            n += s.charAt(i) - '0';

            i++;
        }

        from.set(i);

        return sign * n;
    }

    public static void main(String[] args) {
        var o = new ConstructBTreeFromString();

        TreeNode.show(o.str2tree("-1(-2)(-3)"));
        TreeNode.show(o.str2tree("4(2(3)(1))(6(5))"));
    }
}







