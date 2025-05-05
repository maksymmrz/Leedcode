package maksym.preparation.medium.array;

import maksym.preparation.util.Util;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        final int N = nums.length;
        int count = 0;

        for (int start = 0; start < k && count < N; start++) {

            int i = start;
            int prev = nums[i];

            do {
                count++;
                i = (i + k) % N;

                int curr = nums[i];
                nums[i] = prev;
                prev = curr;
            } while (i != start);
        }
    }

    public static void main(String[] args) {
        var o = new RotateArray();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        o.rotate(arr, 4);
        Util.show(arr);
    }
}
