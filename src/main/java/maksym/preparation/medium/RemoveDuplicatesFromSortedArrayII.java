package maksym.preparation.medium;

import maksym.preparation.util.Util;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            int k = j;
            while (k < nums.length && nums[k] == nums[j]) {
                if (k - j < 2) {
                    nums[i] = nums[k];
                    i++;
                }
                k++;
            }
            j = k - 1;
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII instance = new RemoveDuplicatesFromSortedArrayII();
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(instance.removeDuplicates(arr));
        Util.show(arr);
    }
}
