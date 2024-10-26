package maksym.preparation.medium.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int len = 0;
        int[] prev = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int[] pair : pairs) {
            if (prev[1] < pair[0]) {
                len++;
                prev = pair;
            } else if (pair[1] < prev[1]) {
                prev = pair;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        MaxLengthPairChain o = new MaxLengthPairChain();
        System.out.println(o.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(o.findLongestChain(new int[][]{{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
    }
}
