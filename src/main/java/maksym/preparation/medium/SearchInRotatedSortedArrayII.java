package maksym.preparation.medium;

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (r + l) / 2;
            if (nums[l] == nums[r]) {
                if (nums[l] == target) return true;
                l++;
                r--;
            } else if (nums[m] < target) {
                if (nums[l] <= nums[m] || nums[m] < nums[r] && target <= nums[r]) l = m + 1;
                else r = m;
            } else {
                if (nums[m] <= nums[r] || nums[l] <= nums[m] && nums[l] <= target) r = m;
                else l = m + 1;
            }
        }
        return nums[l] == target;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII instance = new SearchInRotatedSortedArrayII();
        int[] arr = new int[]{4, 5, 6, 7, 7, 8, 9, 0, 1, 2};
        int[] arr1 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(instance.search(arr, 9));
        System.out.println(instance.search(arr1, 2));
    }
}
