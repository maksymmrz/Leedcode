package maksym.preparation.medium.bsearch;

import java.util.Random;

public class RandomPickWithWeight {
    private final Random rand;
    private final int lim;
    private final int[] sums;

    public RandomPickWithWeight(int[] w) {
        this.rand = new Random(System.currentTimeMillis());
        this.sums = new int[w.length];

        int prev = 0;
        for (int i = 0; i < w.length; i++) {
            this.sums[i] = prev + w[i];
            prev = this.sums[i];
        }

        this.lim = prev;
    }

    public int pickIndex() {
        int n = rand.nextInt(lim) + 1;

        int l = 0;
        int r = sums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (sums[m] < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        RandomPickWithWeight r = new RandomPickWithWeight(new int[] {4, 3, 2, 1});
        int[] counter = new int[4];
        for (int i = 0; i < 10000; i++) {
            counter[r.pickIndex()]++;
        }
        for (double d : counter) {
            System.out.println(d / 10000);
        }
    }
}
