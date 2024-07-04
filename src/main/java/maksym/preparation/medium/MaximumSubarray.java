package maksym.preparation.medium;

public class MaximumSubarray {

    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            sum = Math.max(sum + num, num);
            max = Math.max(sum, max);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        return maxSubArr(nums, 0, nums.length - 1);
    }

    public int maxSubArr(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r + 1) / 2;

        int left = maxSubArr(nums, l, mid - 1);
        int right = maxSubArr(nums, mid, r);
        int center = center(nums, l, r);

        return Math.max(left, Math.max(center, right));
    }

    public int center(int[] nums, int from, int to) {
        final int mid = (from + to + 1) / 2;

        int sumL = 0;
        int curr = 0;

        for (int i = mid - 1; i >= from; i--) {
            curr += nums[i];
            sumL = Math.max(curr, sumL);
        }

        int sumR = nums[mid];
        curr = nums[mid];

        for (int i = mid + 1; i <= to; i++) {
            curr += nums[i];
            sumR = Math.max(curr, sumR);
        }
        return sumL + sumR;
    }

    public static void main(String[] args) {
        MaximumSubarray instance = new MaximumSubarray();

        int[] seq1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(instance.maxSubArray(seq1));
        System.out.println(instance.maxSubArray1(seq1));

        int[] seq2 = new int[]{5, 4, -1, 7, 8};
        System.out.println(instance.maxSubArray(seq2));
        System.out.println(instance.maxSubArray1(seq2));

        int[] seq3 = new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};
        System.out.println(instance.maxSubArray(seq3));
        System.out.println(instance.maxSubArray1(seq3));
    }
}
