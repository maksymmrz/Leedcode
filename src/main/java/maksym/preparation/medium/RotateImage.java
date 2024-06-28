package maksym.preparation.medium;

import maksym.preparation.util.Util;

public class RotateImage {

    public void rotate(int[][] matrix) {
        final int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int x = n - 1 - i;
                swap(matrix, i, j, x, j);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int x, int y) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImage instance = new RotateImage();
        instance.rotate(matrix);
        Util.show2d(matrix);
    }
}
