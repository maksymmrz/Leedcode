package maksym.preparation.medium.dp;

import java.util.stream.IntStream;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        final int n = costs.length;
        final int k = costs[0].length;

        for (int i = 1; i < n; i++) {
            int[] lowest = lowestTwo(costs[i - 1]);
            int minIdx = lowest[2];
            int minSum = lowest[0];
            int secondMinSum = lowest[1];

            for (int j = 0; j < k; j++) {
                if (j != minIdx) {
                    costs[i][j] += minSum;
                } else {
                    costs[i][j] += secondMinSum;
                }
            }
        }
        return IntStream.of(costs[n - 1]).min().orElse(0);
    }

    private int[] lowestTwo(int[] arr) {
        int min = Integer.MAX_VALUE;
        int before = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                before = min;
                min = arr[i];
                idx = i;

            } else if (arr[i] < before) {
                before = arr[i];
            }
        }
        return new int[]{min, before, idx};
    }

    public static void main(String[] args) {
        PaintHouseII o = new PaintHouseII();
        System.out.println(o.minCostII(new int[][]{{1, 5, 3}, {2, 9, 4}}));
    }
}
