package maksym.preparation.hard;

import java.util.Arrays;
import java.util.stream.Stream;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        final int n = envelopes.length;
        int[] seq = Stream.of(envelopes).mapToInt(pair -> pair[1]).toArray();
        int[] sorted = new int[n];
        int lim = 0;

        for (int num : seq) {
            if (lim == 0) {
                sorted[0] = num;
                lim++;
            } else {
                if (sorted[lim - 1] < num) {
                    sorted[lim] = num;
                    lim++;
                } else {
                    int j = bs(sorted, lim - 1, num);
                    sorted[j] = num;
                }
            }
        }
        return lim;
    }

    public int bs(int[] arr, int to, int target) {
        int from = 0;
        while (from < to) {
            int m = (from + to) / 2;
            if (arr[m] < target) from = m + 1;
            else to = m;
        }
        return from;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes o = new RussianDollEnvelopes();
        System.out.println(o.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(o.maxEnvelopes(new int[][]{{30, 50}, {12, 2}, {3, 4}, {12, 15}}));
    }
}
