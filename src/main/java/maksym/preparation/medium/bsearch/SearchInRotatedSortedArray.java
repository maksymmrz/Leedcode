package maksym.preparation.medium.bsearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        var l = 0;
        var r = nums.length - 1;

        while (l < r) {
            var m = l + (r - l) / 2;

            if (nums[l] <= nums[m]) {
                if (nums[m] < target || target < nums[l]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }

        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        System.out.println(instance.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(instance.search(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2}, 9));
        System.out.println(instance.search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, 12));
        System.out.println(instance.search(new int[]{5, 1, 3}, 5));
        System.out.println(instance.search(new int[]{3, 5, 1}, 3));
    }
}
