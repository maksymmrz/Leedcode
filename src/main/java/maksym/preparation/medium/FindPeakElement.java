package maksym.preparation.medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        final int n = nums.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (mid + 1 < n && nums[mid] < nums[mid + 1]) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        FindPeakElement instance = new FindPeakElement();
        System.out.println(instance.findPeakElement(new int[]{5,4,9,2,1}));
        System.out.println(instance.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
