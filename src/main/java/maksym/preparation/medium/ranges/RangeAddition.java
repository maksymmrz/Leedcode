package maksym.preparation.medium.ranges;

import maksym.preparation.util.Util;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] prefix = new int[length];

        for (int[] update : updates) {
            int from = update[0];
            int to = update[1];
            int inc = update[2];

            prefix[from] += inc;

            if (to + 1 < length) {
                prefix[to + 1] -= inc;
            }
        }


        for (int i = 1; i < length; i++) {
            prefix[i] += prefix[i - 1];
        }
        return prefix;
    }

    public static void main(String[] args) {
        RangeAddition o = new RangeAddition();

        Util.show(o.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}}));
    }
}
