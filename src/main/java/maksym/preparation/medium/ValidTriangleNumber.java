package maksym.preparation.medium;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;

            while (l < r) {
                if (nums[l] + nums[r] <= nums[i]) {
                    l++;
                } else {
                    count += r - l;
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ValidTriangleNumber o = new ValidTriangleNumber();
        System.out.println(o.triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(o.triangleNumber(new int[]{4, 2, 3, 4}));
    }
}
