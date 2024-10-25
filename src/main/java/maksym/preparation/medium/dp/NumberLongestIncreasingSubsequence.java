package maksym.preparation.medium.dp;

public class NumberLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        final int N = nums.length;
        if (N == 0) return 0;

        int[] lens = new int[N];
        int[] counts = new int[N];
        lens[0] = 1;
        counts[0] = 1;
        int maxLen = 0;
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            int len = 0;
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len == lens[j]) {
                        count += counts[j];
                    } else if (len < lens[j]) {
                        len = lens[j];
                        count = counts[j];
                    }
                }
            }
            lens[i] = len + 1;
            counts[i] = count;

            if (maxLen < lens[i]) {
                maxLen = lens[i];
                maxCount = counts[i];
            } else if (maxLen == lens[i]) {
                maxCount += counts[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        NumberLongestIncreasingSubsequence o = new NumberLongestIncreasingSubsequence();
        System.out.println(o.findNumberOfLIS(new int[]{1, 1, 1, 1, 1}));
        System.out.println(o.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
        System.out.println(o.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
