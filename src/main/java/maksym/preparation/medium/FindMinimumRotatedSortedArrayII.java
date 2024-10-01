package maksym.preparation.medium;

public class FindMinimumRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] == nums[r]) l++;
            else {
                int mid = (l + r) / 2;
                if (nums[l] <= nums[mid] && nums[mid] <= nums[r]) r = mid;
                else if (nums[mid] <= nums[r] && nums[l] > nums[mid]) r = mid;
                else l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        FindMinimumRotatedSortedArrayII instance = new FindMinimumRotatedSortedArrayII();
        System.out.println(instance.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(instance.findMin(new int[]{3, 3, 1, 3}));
        System.out.println(instance.findMin(new int[]{1,3,3,3}));
    }
}
