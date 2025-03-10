package maksym.preparation.medium.swindow;

public class ShortestSubarrayRemoveToMakeSorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        final int n = arr.length;

        int j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) j--;

        int maxLen = n - j;

        for (int i = 0; i < n; i++) {
            while (j < n && arr[i] > arr[j]) j++;

            if (i < j && (i == 0 || arr[i - 1] <= arr[i])) {
                int len = i + 1 + n - j;
                maxLen = Math.max(len, maxLen);
            } else break;
        }

        return n - maxLen;
    }

    public static void main(String[] args) {
        ShortestSubarrayRemoveToMakeSorted o = new ShortestSubarrayRemoveToMakeSorted();
        System.out.println(o.findLengthOfShortestSubarray(new int[]{6, 3, 10, 11, 15, 20, 13, 3, 18, 12}));
        System.out.println(o.findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
    }
}
