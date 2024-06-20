package maksym.preparation.hard;


import java.util.stream.IntStream;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        final int max = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < max) {
                int n = nums[i];
                int tmp = nums[n - 1];
                if (n != tmp) {
                    nums[n - 1] = n;
                    nums[i] = tmp;
                } else break;
            }
        }

        int positive = 1;

        for (int n : nums) {
            if (n == positive) {
                positive++;
            }
        }
        return positive;
    }

    public int firstMissingPositiveII(int[] nums) {
        boolean hasNoOne = IntStream.of(nums).filter(n -> n == 1).findFirst().isEmpty();
        if (hasNoOne) return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) > 0) {
                int n = Math.abs(nums[i]);
                nums[n - 1] = -Math.abs(nums[n - 1]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive instance = new FirstMissingPositive();
        System.out.println(instance.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(instance.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(instance.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println();
        System.out.println(instance.firstMissingPositiveII(new int[]{1, 2, 0}));
        System.out.println(instance.firstMissingPositiveII(new int[]{3, 4, -1, 1}));
        System.out.println(instance.firstMissingPositiveII(new int[]{7, 8, 9, 11, 12}));
    }
}
