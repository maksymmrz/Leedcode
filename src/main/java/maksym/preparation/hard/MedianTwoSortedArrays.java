package maksym.preparation.hard;

public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        final int m = nums1.length;
        final int n = nums2.length;
        final int len = m + n;
        final int half = (len + 1) / 2;

        int l = 0;
        int r = n - 1;

        if (n == 0) {
            int med = m / 2;
            return m % 2 == 0 ? (nums1[med - 1] + nums1[med]) / 2.0 : nums1[med];
        }

        while (l < r) {
            int med = (l + r) / 2;
            int i = half - med - 1;
            if (nums2[med] < nums1[i]) l = l + 1;
            else r = med;
        }
        final int firstMed = half - l - 1;
        final int secondMed = l;

        if (len % 2 == 0) {
            if (nums1[firstMed] <= nums2[secondMed]) {
                int f1 = nums1[firstMed];
                int f2 = firstMed + 1 < m ? nums1[firstMed + 1] : Integer.MAX_VALUE;
                int s1 = secondMed > 0 ? nums2[secondMed - 1] : Integer.MIN_VALUE;
                int s2 = nums2[secondMed];
                return (Math.max(f1, s1) + Math.min(f2, s2)) / 2.0;
            } else {
                int f1 = firstMed > 0 ? nums1[firstMed - 1] : Integer.MIN_VALUE;
                int f2 = nums1[firstMed];
                int s = nums2[secondMed];
                return (Math.max(f1, s) + f2) / 2.0;
            }
        } else {
            if (nums1[firstMed] < nums2[secondMed]) {
                int f = nums1[firstMed];
                int s = secondMed > 0 ? nums2[secondMed - 1] : Integer.MIN_VALUE;
                return Math.max(f, s);
            } else {
                return Math.max(nums1[firstMed - 1], nums2[secondMed]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{6,7,8,9,11,12,13,14,15,16,17};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
