package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.Arrays;

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        final int max = Arrays.stream(nums).max().orElse(5000);
        int[] buckets = new int[max + 1];

        for (int num : nums) {
            buckets[num]++;
        }

        int right = buckets.length - 1;

        for (int i = 1; i < nums.length; i += 2) {
            while (right >= 0 && buckets[right] == 0) right--;
            nums[i] = right;
            buckets[right]--;
        }

        for (int i = 0; i < nums.length; i += 2) {
            while (right >= 0 && buckets[right] == 0) right--;
            nums[i] = right;
            buckets[right]--;
        }
    }

    public static void main(String[] args) {
        WiggleSortII instance = new WiggleSortII();

        int[] nums1 = new int[]{4, 5, 5, 6};
        int[] nums2 = new int[]{5, 5, 4, 5, 4, 4, 4};
        int[] nums3 = new int[]{1, 3, 2, 2, 3, 1};
        int[] nums4 = new int[]{1};

        instance.wiggleSort(nums1);
        instance.wiggleSort(nums2);
        instance.wiggleSort(nums3);
        instance.wiggleSort(nums4);

        Util.show(nums1);
        Util.show(nums2);
        Util.show(nums3);
        Util.show(nums4);
    }
}
