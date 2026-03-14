package maksym.preparation.medium.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfWaysToBuildSturdyBrickWall {

    private final static int MOD = 1_000_000_007;

    public int buildWall(int height, int width, int[] bricks) {
        List<Integer> masks = new ArrayList<>();
        generateMasks(0, 0, width, bricks, masks);

        final int N = masks.size();

        List<List<Integer>> compatibility = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            compatibility.add(new ArrayList<>());

            for (int j = 0; j < N; j++) {
                if ((masks.get(i) & masks.get(j)) == 0) {
                    compatibility.get(i).add(j);
                }
            }
        }

        int[][] dp = new int[height][N];

        Arrays.fill(dp[0], 1);

        for (int h = 1; h < height; h++) {
            for (int i = 0; i < N; i++) {
                for (int j : compatibility.get(i)) {
                    dp[h][i] = (dp[h][i] + dp[h - 1][j]) % MOD;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            ans = (ans + dp[height - 1][i]) % MOD;
        }

        return ans;
    }

    private void generateMasks(int i, int mask, int width, int[] bricks, List<Integer> acc) {
        if (i == width) {
            acc.add(mask);
        } else {
            for (int brick : bricks) {
                int nextIdx = i + brick;
                if (nextIdx > width) continue;

                int nextMask = mask;
                if (nextIdx < width) {
                    nextMask |= 1 << nextIdx;
                }

                generateMasks(nextIdx, nextMask, width, bricks, acc);
            }
        }
    }

    public static void main(String[] args) {
        var o = new NumberOfWaysToBuildSturdyBrickWall();
        System.out.println(o.buildWall(2, 3, new int[]{1, 2}));
        System.out.println(o.buildWall(76, 9, new int[]{6,3,5,1,9}));
    }
}
