package maksym.preparation.hard.bsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        var seq = new ArrayList<Integer>();

        for (int[] envelope : envelopes) {
            int w = envelope[1];

            binarySearch(w, seq);
        }

        return seq.size();
    }

    private void binarySearch(int n, ArrayList<Integer> seq) {
        int l = 0;
        int r = seq.size() - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (seq.get(m) < n) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (seq.isEmpty() || seq.get(l) < n) {
            seq.add(n);
        } else {
            seq.set(l, n);
        }
    }

    public static void main(String[] args) {
        RussianDollEnvelopes o = new RussianDollEnvelopes();
        System.out.println(o.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(o.maxEnvelopes(new int[][]{{30, 50}, {12, 2}, {3, 4}, {12, 15}}));
        System.out.println(o.maxEnvelopes(new int[][]{{1, 1}, {1, 1}}));
    }
}
