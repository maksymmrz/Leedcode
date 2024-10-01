package maksym.preparation.medium;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[l] <= nums[mid] && nums[mid] < nums[r]) r = mid;
            else if (nums[mid] <= nums[r] && nums[l] > nums[mid]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray instance = new MinimumInRotatedSortedArray();
        //System.out.println(instance.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(instance.findMin(new int[]{3, 1, 2}));
    }
}
