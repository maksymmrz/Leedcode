package maksym.preparation.medium.dp;

import java.util.*;

public class LongestArithmeticSubsequenceGivenDiff {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i : arr) {
            int next = i - difference;
            int len = map.getOrDefault(next, 0) + 1;
            map.put(i, len);
            max = Math.max(len, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceGivenDiff o = new LongestArithmeticSubsequenceGivenDiff();
        System.out.println(o.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}
