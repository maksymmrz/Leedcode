package maksym.preparation.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindFirstAndLastInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        final int n = nums.length;
        int start;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        start = l;
        if (n == 0 || nums[start] != target) return new int[]{-1, -1};
        r = n - 1;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (nums[m] <= target) l = m;
            else r = m - 1;
        }
        return new int[]{start, r};
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13};
        int[] arr2 = new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] arr3 = new int[]{5, 7, 7, 9, 9, 10};
        FindFirstAndLastInSortedArray instance = new FindFirstAndLastInSortedArray();
        System.out.println(Arrays.stream(instance.searchRange(arr1, 8)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(instance.searchRange(arr2, 4)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(instance.searchRange(arr3, 7)).boxed().collect(Collectors.toList()));
    }
}
