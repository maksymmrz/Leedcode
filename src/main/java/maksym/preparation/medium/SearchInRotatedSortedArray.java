package maksym.preparation.medium;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r + 1) / 2;

            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
        }

        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] arr2 = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2};
        int[] arr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] arr4 = new int[]{5, 1, 3};
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        System.out.println(instance.search(arr1, 1));
        System.out.println(instance.search(arr2, 9));
        System.out.println(instance.search(arr3, 12));
        System.out.println(instance.search(arr4, 3));
    }
}
