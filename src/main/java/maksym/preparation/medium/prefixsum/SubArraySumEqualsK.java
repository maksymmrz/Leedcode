package maksym.preparation.medium.prefixsum;

import java.util.*;

public class SubArraySumEqualsK {
    public int subArraySum(int[] nums, int k) {
        int prefix = 0;
        int ans = 0;

        Map<Integer, Integer> memo = new HashMap<>();

        memo.put(0, 1);

        for (int n : nums) {
            prefix += n;

            int diff = prefix - k;

            int freq = memo.getOrDefault(diff, 0);

            ans += freq;

            memo.put(prefix, memo.getOrDefault(prefix, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        var o = new SubArraySumEqualsK();

        System.out.println(o.subArraySum(new int[]{1, 2, 3}, 3));
        System.out.println(o.subArraySum(new int[]{1, 3, -1, 3, 1, -3, 4}, 5));
    }
}
