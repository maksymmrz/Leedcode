package maksym.preparation.hard;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        final int m = dungeon.length;
        final int n = dungeon[0].length;
        final int max = 1 << 30;
        int[][] health = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int right = j + 1 < n ? health[i][j + 1] : max;
                int bellow = i + 1 < m ? health[i + 1][j] : max;

                int prevHealth = i == m - 1 && j == n - 1 ? 1 : Math.min(right, bellow);

                health[i][j] = Math.max(1, prevHealth - dungeon[i][j]);
            }
        }
        return health[0][0];
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, -3, 3},
                {0, -2, 0},
                {-3, -3, -3}
        };
        DungeonGame instance = new DungeonGame();
        System.out.println(instance.calculateMinimumHP(matrix1));
        System.out.println(instance.calculateMinimumHP(new int[][]{{0, 0}}));
        System.out.println(instance.calculateMinimumHP(new int[][]{{100}}));
    }
}
