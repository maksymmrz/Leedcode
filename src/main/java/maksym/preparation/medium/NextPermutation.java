package maksym.preparation.medium;

import java.util.Arrays;
import java.util.TreeMap;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int left = nums.length;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                left = i - 1;
                break;
            }
        }

        int right = -1;
        for (int i = nums.length - 1; left < i; i--) {
            if (nums[left] < nums[i]) {
                if (right < 0) {
                    right = i;
                } else if (nums[right] > nums[i]) {
                    right = i;
                }
            }
        }

        if (left == nums.length) {
            for (int i = 0; i < nums.length/2; i++) {
                swap(nums, i, nums.length - i - 1);
            }
        } else {
            swap(nums, left, right);
            Arrays.sort(nums, left + 1, nums.length);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,4,3,2,1};
        new NextPermutation().nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
