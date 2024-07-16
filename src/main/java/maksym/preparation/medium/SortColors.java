package maksym.preparation.medium;

import maksym.preparation.util.Util;

public class SortColors {
    public void sortColors(int[] nums) {
        final int mid = 1;
        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {
            if (nums[j] < mid) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] > mid) {
                swap(nums, j, k);
                k--;
            } else j++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public static void main(String[] args) {
        SortColors instance = new SortColors();

        int[] nums = {2,0,2,1,1,0};
        int[] nums0 = {1,2,0,0};

        instance.sortColors(nums);
        instance.sortColors(nums0);

        Util.show(nums);
        Util.show(nums0);
    }
}
