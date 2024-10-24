package maksym.preparation.medium.dp;

import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        final int N = nums.length;
        List<Integer> arr = new ArrayList<>();

        int maxLen;
        if (N > 0) {
            arr.add(nums[0]);
            maxLen = 1;
        } else {
            maxLen = 0;
        }

        for (int i = 1; i < N; i++) {
            if (arr.get(arr.size() - 1) < nums[i]) {
                arr.add(nums[i]);
                maxLen = Math.max(arr.size(), maxLen);
            } else {
                int j = bs(arr, nums[i]);
                arr.set(j, nums[i]);
                maxLen = Math.max(j + 1, maxLen);
            }
        }
        return maxLen;
    }

    private int bs(List<Integer> arr, int value) {
        int l = 0;
        int r = arr.size() - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) < value) l = m + 1;
            else r = m;
        }
        return l;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence o = new LongestIncreasingSubsequence();
        System.out.println(o.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
