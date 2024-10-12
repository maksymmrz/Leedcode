package maksym.preparation.medium;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (m % 2 == 0) {
                if (nums[m] == nums[m + 1]) l = m + 1;
                else r = m;
            } else {
                if (nums[m] != nums[m + 1]) l = m + 1;
                else r = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        SingleElementInSortedArray instance = new SingleElementInSortedArray();
        System.out.println(instance.singleNonDuplicate(new int[]{1, 1, 2, 2, 3}));
        System.out.println(instance.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(instance.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(instance.singleNonDuplicate(new int[]{1, 1, 2, 2, 4, 4, 7, 8, 8, 9, 9}));
    }
}
