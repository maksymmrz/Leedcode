package maksym.preparation.medium;

import maksym.preparation.util.Util;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        final int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
            if (i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        WiggleSort instance = new WiggleSort();

        int[] nums1 = new int[]{3, 5, 2, 1, 6, 4};
        int[] nums2 = new int[]{6, 6, 5, 6, 3, 8};
        int[] nums3 = new int[]{7, 6, 5, 4, 3, 2, 1};
        int[] nums4 = new int[]{1};
        int[] nums5 = new int[]{2,1};

        instance.wiggleSort(nums1);
        instance.wiggleSort(nums2);
        instance.wiggleSort(nums3);
        instance.wiggleSort(nums4);
        instance.wiggleSort(nums5);

        Util.show(nums1);
        Util.show(nums2);
        Util.show(nums3);
        Util.show(nums4);
        Util.show(nums5);
    }
}
