package maksym.preparation.medium.array;

import maksym.preparation.util.Util;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {
    private final int[] origin;
    private final Random rand = new Random(System.currentTimeMillis());

    public ShuffleArray(int[] nums) {
        origin = new int[nums.length];

        System.arraycopy(nums, 0, origin, 0, origin.length);
    }

    public int[] reset() {
        return Arrays.copyOf(origin, origin.length);
    }

    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(origin, origin.length);

        for (int i = 0; i < shuffled.length; i++) {
            int j = rand.nextInt(i, shuffled.length);

            swap(shuffled, i, j);
        }

        return shuffled;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        var o = new ShuffleArray(new int[]{1, 2, 3, 4, 5, 6, 7});

        int[] counts = new int[8];

        for (int i = 0; i < 10000; i++) {
            var shuffled = o.shuffle();
            counts[shuffled[3]]++;
        }

        Util.show(counts);
    }
}
