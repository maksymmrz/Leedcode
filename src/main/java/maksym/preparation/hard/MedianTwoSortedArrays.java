package maksym.preparation.hard;

public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        final int n = nums1.length;
        final int m = nums2.length;
        final int len  = n + m;


        int l = 0;
        int r = n;

        while (l <= r) {

            int i = (l + r) >> 1;
            int j = ((len + 1) >> 1) - i;

            int leftX = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int leftY = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int rightX = i < n ? nums1[i] : Integer.MAX_VALUE;
            int rightY = j < m ? nums2[j] : Integer.MAX_VALUE;

            int leftMax = Math.max(leftX, leftY);
            int rightMin = Math.min(rightX, rightY);

            if (leftMax <= rightMin) {
                if (len % 2 == 0) {
                    return (leftMax + rightMin) / 2.0;
                } else {
                    return leftMax;
                }
            } else if (leftX > rightY) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
