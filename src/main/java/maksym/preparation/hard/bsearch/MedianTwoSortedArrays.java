package maksym.preparation.hard.bsearch;

public class MedianTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        final int M = nums1.length;
        final int N = nums2.length;

        if (N == 0) {
            int med = M / 2;
            return M % 2 == 0 ? (nums1[med - 1] + nums1[med]) / 2.0 : nums1[med];
        }

        final int half = (M + N - 1) / 2;

        int l = 0;
        int r = N - 1;

        while (l < r) {
            int j = l + (r - l) / 2;
            int i = half - j;

            if (nums1[i] > nums2[j]) {
                l = j + 1;
            } else {
                r = j;
            }
        }

        int i = half - l;
        int j = l;

        if ((M + N) % 2 == 0) {
            if (nums1[i] <= nums2[j]) {
                int maxFirst = nums1[i];
                int maxSecond = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;

                int minFirst = i < M - 1 ? nums1[i + 1] : Integer.MAX_VALUE;
                int minSecond = nums2[j];

                return ((double) Math.max(maxFirst, maxSecond) + Math.min(minFirst, minSecond)) / 2;
            } else {
                int n1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
                int n2 = nums2[j];

                int n3 = nums1[i];
                int n4 = j < N - 1 ? nums2[j + 1] : Integer.MAX_VALUE;

                return ((double) Math.max(n1, n2) + Math.min(n3, n4)) / 2;
            }
        } else {
            if (nums1[i] <= nums2[j]) {
                int n1 = nums1[i];
                int n2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
                return Math.max(n1, n2);
            } else {
                int n1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
                int n2 = nums2[j];
                return Math.max(n1, n2);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 7};
        int[] arr2 = new int[]{2, 4, 6};

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
