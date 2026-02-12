package maksym.preparation.medium.swindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        final var N = nums.length;

        var minLen = Integer.MAX_VALUE;
        var sum = 0;
        var left = 0;
        var right = 0;

        while (right < N) {
            sum += nums[right];

            while (left < right && sum - nums[left] >= target) {
                sum -= nums[left];
                left++;
            }

            if (sum >= target) {
                minLen = Math.min(right - left + 1, minLen);
            }

            right++;
        }

        return minLen < Integer.MAX_VALUE ? minLen : 0;
    }

    public static void main(String[] args) {
        var o = new MinimumSizeSubarraySum();
        System.out.println(o.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(o.minSubArrayLen(5, new int[]{1, 2, 2, 3, 1}));
    }
}
