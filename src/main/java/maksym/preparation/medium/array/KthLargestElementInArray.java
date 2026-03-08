package maksym.preparation.medium.array;

import java.util.Random;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] arr, int l, int r, int k) {
        var rand = new Random(r - l);
        var p = rand.nextInt(l, r + 1);
        var pivot = arr[p];
        swap(arr, p, r);

        int m = l;

        for (int i = l; i < r; i++) {
            if (arr[i] > pivot) {
                swap(arr, m, i);
                m++;
            }
        }
        swap(arr, m, r);

        if (m == k - 1) {
            return arr[m];
        }

        if (m >= k - 1) {
            return quickSelect(arr, l, m - 1, k);
        } else {
            return quickSelect(arr, m + 1, r, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        var o = new KthLargestElementInArray();
        System.out.println(o.findKthLargest(new int[]{3, 1, 2, 4}, 3));
        System.out.println(o.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
