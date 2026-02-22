package maksym.preparation.medium.swindow;

import java.util.Arrays;

public class LongestBalancedSubstringI {
    public int longestBalanced(String s) {
        final int N = s.length();
        int maxSubstrLen = 0;
        int[] counts = new int[26];

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                counts[s.charAt(j) - 'a']++;

                int maxFr = 0;
                int minFr = N;

                for (int count : counts) {
                    if (count != 0) {
                        maxFr = Math.max(count, maxFr);
                        minFr = Math.min(count, minFr);
                    }
                }

                if (minFr == maxFr) {
                    maxSubstrLen = Math.max(j - i + 1, maxSubstrLen);
                }
            }
            Arrays.fill(counts, 0);
        }
        return maxSubstrLen;
    }

    public static void main(String[] args) {
        var o = new LongestBalancedSubstringI();

        System.out.println(o.longestBalanced("zzabccy"));
    }
}
