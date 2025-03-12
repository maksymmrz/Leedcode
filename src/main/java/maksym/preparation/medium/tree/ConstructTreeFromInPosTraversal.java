package maksym.preparation.medium.tree;

import maksym.preparation.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInPosTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> ins = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            ins.put(inorder[i], i);
        }
        return recB(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, ins);
    }

    public TreeNode recB(
            int[] inorder,
            int left,
            int right,
            int[] postorder,
            int start,
            int end,
            Map<Integer, Integer> ins
    ) {
        if (right < left) return null;
        if (left == right) return new TreeNode(inorder[left]);

        int head = postorder[end];
        int headIdx = ins.get(head);

        int postM = start + (headIdx - left);

        TreeNode leftNode = recB(inorder, left, headIdx - 1, postorder, start, postM - 1, ins);
        TreeNode rightNode = recB(inorder, headIdx + 1, right, postorder, postM,end - 1, ins);

        return new TreeNode(head, leftNode, rightNode);
    }

    public static void main(String[] args) {
        ConstructTreeFromInPosTraversal instance = new ConstructTreeFromInPosTraversal();

        TreeNode tree1 = instance.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        TreeNode.show(tree1);

        TreeNode tree2 = instance.buildTree(new int[]{1,2,3,4}, new int[]{3,2,4,1});
        TreeNode.show(tree2);
    }
}
