package maksym.preparation.medium.array;

import maksym.preparation.util.Util;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] arr, int from, int to) {
        if (from < to) {
            int mid = split(arr, from, to);

            sort(arr, from, mid - 1);
            sort(arr, mid, to);
        }
    }

    private int split(int[] arr, int from, int to) {
        int m = (from + to) / 2;
        int mark = arr[m];
        int l = from;
        int r= to;

        while (l <= r) {
            while (l <= r && arr[l] < mark) l++;
            while (l <= r && arr[r] > mark) r--;

            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }

        return l;
    }

    private void swap(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        var o = new SortAnArray();
        var arr = new int[]{5, 1, 2, 4, 3};

        Util.show(o.sortArray(arr));
    }
}
