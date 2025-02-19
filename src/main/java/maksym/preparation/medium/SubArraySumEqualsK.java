package maksym.preparation.medium;

import java.util.*;

public class SubArraySumEqualsK {
    public int subArraySum(int[] nums, int k) {
        int total = 0;
        int prefix = 0;
        Map<Integer, Integer> cache = new HashMap<>();

        for (int num : nums) {
            prefix += num;

            int count = cache.getOrDefault(prefix - k, 0);

            if (prefix == k) count++;

            total += count;

            cache.put(prefix, 1 + cache.getOrDefault(prefix, 0));
        }
        return total;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK o = new SubArraySumEqualsK();
        System.out.println(o.subArraySum(new int[]{1, 3, -1, 3, 1, -3, 4}, 5));
    }
}
