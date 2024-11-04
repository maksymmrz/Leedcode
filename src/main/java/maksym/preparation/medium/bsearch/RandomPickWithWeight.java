package maksym.preparation.medium.bsearch;

import java.util.Random;

public class RandomPickWithWeight {
    private final Random rand;
    private final int[] sums;
    private final int max;

    public RandomPickWithWeight(int[] w) {
        rand = new Random(System.currentTimeMillis());
        sums = new int[w.length];

        for (int i = 0; i < w.length; i++) {
            sums[i] = w[i];
            if (i > 0) sums[i] += sums[i - 1];
        }
        max = sums[sums.length - 1];
    }

    public int pickIndex() {
        int num = 1 + rand.nextInt(max);

        int l = 0;
        int r = sums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (sums[m] < num) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        RandomPickWithWeight r = new RandomPickWithWeight(new int[] {4, 3, 1, 1, 1, 0});
        int[] counter = new int[6];
        for (int i = 0; i < 10000; i++) {
            counter[r.pickIndex()]++;
        }
        for (double d : counter) {
            System.out.println(d / 10000);
        }
    }
}
