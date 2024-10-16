package maksym.preparation.medium.dp;

import java.util.stream.IntStream;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int left = j > 0 ? matrix[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = j + 1 < N ? matrix[i - 1][j + 1] : Integer.MAX_VALUE;
                int upper = matrix[i - 1][j];
                matrix[i][j] += Math.min(upper, Math.min(left, right));
            }
        }

        return IntStream.of(matrix[M - 1]).min().orElse(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        MinimumFallingPathSum o = new MinimumFallingPathSum();
        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(o.minFallingPathSum(matrix));
    }
}
