package maksym.preparation.hard.bsearch;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (int n : nums) right += n;

        while (left < right) {
            int threshold = (left + right) / 2;

            if (isThresholdValid(nums, k, threshold)) right = threshold;
            else left = threshold + 1;
        }
        return left;
    }

    private boolean isThresholdValid(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int n : arr) {
            if (k == 0 || n > threshold) return false;

            if (sum + n <= threshold) {
                sum += n;
            } else if (k == 1) return false;
            else {
                sum = n;
                k--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum o = new SplitArrayLargestSum();
        System.out.println(o.splitArray(new int[]{0}, 3));
        System.out.println(o.splitArray(new int[]{2, 3, 1, 2, 4, 3}, 3));
        System.out.println(o.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
