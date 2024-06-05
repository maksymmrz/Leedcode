package maksym.preparation.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        int right = l;
        l = 0;
        r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums.length <= l || nums[l] != target) return new int[]{-1, - 1};
        else return new int[]{l, right};
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13};
        int[] arr2 = new int[]{1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] arr3 = new int[]{5, 7, 7, 9, 9, 10};
        FindFirstAndLastPositionOfElementInSortedArray instance = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.stream(instance.searchRange(arr1, 8)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(instance.searchRange(arr2, 4)).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(instance.searchRange(arr3, 7)).boxed().collect(Collectors.toList()));
    }
}
