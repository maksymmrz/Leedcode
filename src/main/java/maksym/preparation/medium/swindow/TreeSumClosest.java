package maksym.preparation.medium.swindow;

import java.util.Arrays;

public class TreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum < target) l++;
                else r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeSumClosest instance = new TreeSumClosest();

        int[] arr1 = new int[]{-1, 2, 1, -4};
        System.out.println(instance.threeSumClosest(arr1, 1));

        int[] arr2 = new int[]{0, 0, 0};
        System.out.println(instance.threeSumClosest(arr2, 1));

        int[] arr3 = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        System.out.println(instance.threeSumClosest(arr3, -2));
    }
}
