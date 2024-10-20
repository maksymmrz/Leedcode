package maksym.preparation.medium.bsearch;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfySum {
    public int numSubseq(int[] nums, int target) {
        final int N = nums.length;
        final int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int count = 0;
        int[] pows = new int[N + 1];
        pows[0] = 1;
        for (int i = 1; i <= N; i++) {
            pows[i] = (2 * pows[i - 1]) % MOD;
        }

        for (int i = 0; i < N && nums[i] < target; i++) {
            int l = i;
            int r = N - 1;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (nums[i] + nums[m] > target) r = m - 1;
                else l = m;
            }
            if (nums[i] + nums[l] <= target) {
                count = (count +  pows[l - i]) % MOD;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfySum o = new NumberOfSubsequencesThatSatisfySum();
        System.out.println(o.numSubseq(new int[]{3, 5, 6, 7}, 9));
        System.out.println(o.numSubseq(new int[]{3, 3, 6, 8}, 10));
        System.out.println(o.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
        System.out.println(o.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
    }
}
