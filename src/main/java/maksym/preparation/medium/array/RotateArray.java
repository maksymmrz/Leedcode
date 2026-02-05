package maksym.preparation.medium.array;

import maksym.preparation.util.Util;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        final var N = nums.length;
        var count = 0;

        for (int start = 0; start < k && count < N; start++) {
            var i = start;
            var prev = nums[i];

            do {
                i = (i + k) % N;
                count++;

                var next = nums[i];
                nums[i] = prev;
                prev = next;
            } while (i != start);
        }
    }

    public static void main(String[] args) {
        var o = new RotateArray();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        o.rotate(arr, 4);
        Util.show(arr);
    }
}
