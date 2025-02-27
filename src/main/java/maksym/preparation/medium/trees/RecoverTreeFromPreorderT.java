package maksym.preparation.medium.trees;

import maksym.preparation.util.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class RecoverTreeFromPreorderT {
    public TreeNode recoverFromPreorder(String traversal) {
        return recover(traversal, 0, new AtomicInteger(0));
    }

    private TreeNode recover(String s, int depth, AtomicInteger idx) {
        if (idx.get() == s.length()) return null;
        else if (depth(s, idx) == depth) {
            skipDashes(s, idx);

            int value = scanNumber(s, idx);

            TreeNode node = new TreeNode(value);

            node.left = recover(s, depth + 1, idx);
            node.right = recover(s, depth + 1, idx);

            return node;
        } else {
            return null;
        }
    }

    private void skipDashes(String s, AtomicInteger idx) {
        while (idx.get() < s.length() && s.charAt(idx.get()) == '-') idx.incrementAndGet();
    }

    private int scanNumber(String s, AtomicInteger idx) {
        int num = 0;
        int i = idx.get();

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num *= 10;
            num += s.charAt(i) - '0';
            i++;
        }

        idx.set(i);
        return num;
    }

    private int depth(String tree, AtomicInteger idx) {
        int i = idx.get();

        while (i < tree.length() && tree.charAt(i) == '-') i++;

        return i - idx.get();
    }

    public static void main(String[] args) {
        RecoverTreeFromPreorderT o = new RecoverTreeFromPreorderT();

        TreeNode tree = o.recoverFromPreorder("1-2--3--4-5--6--7");
        TreeNode.show(tree);
    }
}
