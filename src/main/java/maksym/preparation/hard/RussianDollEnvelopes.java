package maksym.preparation.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return -(a[1] - b[1]);
            else return a[0] - b[0];
        });

        final int N = envelopes.length;
        int max = 0;
        List<int[]> seq = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                seq.add(envelopes[i]);
            } else {
                int[] last = seq.get(seq.size() - 1);
                if (last[0] < envelopes[i][0] && last[1] < envelopes[i][1]) {
                    seq.add(envelopes[i]);
                } else {
                    int j = bs(seq, envelopes[i]);
                    seq.set(j, envelopes[i]);
                }
            }
            max = Math.max(seq.size(), max);
        }
        return max;
    }

    private int bs(List<int[]> seq, int[] target) {
        int l = 0;
        int r = seq.size() - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (seq.get(m)[1] < target[1]) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        RussianDollEnvelopes o = new RussianDollEnvelopes();
        System.out.println(o.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(o.maxEnvelopes(new int[][]{{30, 50}, {12, 2}, {3, 4}, {12, 15}}));
    }
}
