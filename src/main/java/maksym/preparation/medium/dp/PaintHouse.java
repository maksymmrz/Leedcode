package maksym.preparation.medium.dp;

public class PaintHouse {
    public int minCost(int[][] costs) {
        int[][] total = new int[2][3];

        for (int[] cost : costs) {
            for (int i = 0; i < 3; i++) {
                total[1][i] = Integer.MAX_VALUE;

                for (int j = 0; j < 3; j++) {
                    if (i != j) {
                        total[1][i] = Math.min(total[0][j], total[1][i]);
                    }
                }
                total[1][i] += cost[i];
            }
            System.arraycopy(total[1], 0, total[0], 0, 3);
        }

        return Math.min(total[1][0], Math.min(total[1][1], total[1][2]));
    }

    public static void main(String[] args) {
        PaintHouse o = new PaintHouse();
        System.out.println(o.minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
    }
}
