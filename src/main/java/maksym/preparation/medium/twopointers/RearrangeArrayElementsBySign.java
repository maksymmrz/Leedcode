package maksym.preparation.medium.twopointers;

import maksym.preparation.util.Util;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        final var N = nums.length;

        int i = 0;
        int j = 0;
        int k = 0;
        var ans = new int[N];

        while (k < N) {
            while (i < N && nums[i] < 0) i++;
            while (j < N && nums[j] > 0) j++;

            ans[k] = nums[i];
            k++;
            ans[k] = nums[j];

            k++;
            i++;
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        var o = new RearrangeArrayElementsBySign();

        Util.show(o.rearrangeArray(new int[]{3, 1, -2, -5, 2, -4}));
    }
}
