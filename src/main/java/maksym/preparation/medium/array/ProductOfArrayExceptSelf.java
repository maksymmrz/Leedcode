package maksym.preparation.medium.array;

import maksym.preparation.util.Util;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        final int N = nums.length;

        var ans = new int[N];

        for (int i = 0; i < N; i++) {
            ans[i] = i == 0 ? 1 : nums[i - 1] * ans[i - 1];
        }

        int suffix = 1;

        for (int i = N - 1; i >= 0; i--) {
            ans[i] *= suffix;

            suffix *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        var o = new ProductOfArrayExceptSelf();

        Util.show(o.productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
