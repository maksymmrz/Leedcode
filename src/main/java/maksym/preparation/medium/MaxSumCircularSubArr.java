package maksym.preparation.medium;

public class MaxSumCircularSubArr {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int minCurr = 0;
        int min = 1 << 28;

        int maxCurr = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            totalSum += num;

            minCurr = Math.min(num + minCurr, num);
            min = Math.min(minCurr, min);

            maxCurr = Math.max(num + maxCurr, num);
            max = Math.max(maxCurr, max);
        }

        if (min == totalSum) return max;

        return Math.max(max, totalSum - min);
    }

    public static void main(String[] args) {
        MaxSumCircularSubArr o = new MaxSumCircularSubArr();
        System.out.println(o.maxSubarraySumCircular(new int[]{-3, -2, -3}));
        System.out.println(o.maxSubarraySumCircular(new int[]{-1, 3, -3, 9, -6, 8, -5, -5, -6, 10}));
    }
}
