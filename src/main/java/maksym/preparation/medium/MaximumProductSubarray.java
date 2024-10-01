package maksym.preparation.medium;


public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prefix = 0;
        int suffix = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= num;
            suffix *= Math.max(num * suffix, num);
            max = Math.max(Math.max(prefix, suffix), max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubarray instance = new MaximumProductSubarray();
        System.out.println(instance.maxProduct(new int[]{2, 3, -1, 0, 2, -3, 4, -1, 1, 0}));
    }
}
