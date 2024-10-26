package maksym.preparation.medium.dp;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        final int N = nums.length;
        int[][] dp = new int[N][1001];
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i][diff + 500] = Math.max(dp[j][diff + 500] + 1, dp[i][diff + 500]);
                max = Math.max(dp[i][diff + 500], max);
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequence o = new LongestArithmeticSubsequence();
        System.out.println(o.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
    }
}
