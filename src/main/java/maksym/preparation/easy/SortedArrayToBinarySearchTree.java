package maksym.preparation.easy;

import maksym.preparation.util.TreeNode;

public class SortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    public TreeNode toBST(int[] arr, int l, int r) {
        if (l > r) return null;
        else if (l == r) return new TreeNode(arr[l]);
        else {
            int mid = (l + r + 1) / 2;
            TreeNode left = toBST(arr, l, mid - 1);
            TreeNode right = toBST(arr, mid + 1, r);
            return new TreeNode(arr[mid], left, right);
        }
    }

    public static void main(String[] args) {
        SortedArrayToBinarySearchTree instance = new SortedArrayToBinarySearchTree();
        TreeNode tree = instance.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        TreeNode.show(tree);
    }
}
