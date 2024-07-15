package maksym.preparation.medium;

import maksym.preparation.util.Util;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int marker = findMarker(matrix);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    setCross(matrix, marker, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == marker) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setCross(int[][] matrix, int marker, int x, int y) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            if (matrix[i][y] != 0) {
                matrix[i][y] = marker;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[x][j] != 0) {
                matrix[x][j] = marker;
            }
        }
    }

    public int findMarker(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int marker = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == marker) {
                    marker--;
                    i = -1;
                    j = n;
                }
            }
        }
        return marker;
    }

    public static void main(String[] args) {
        SetMatrixZeroes instance = new SetMatrixZeroes();

        int[][] matrix1 = new int[][]{
                {1, 0, 1, 1, 1, 0, 2},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
        };

        int[][] matrix2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        instance.setZeroes(matrix1);
        instance.setZeroes(matrix2);
        Util.show2d(matrix1);
        Util.show2d(matrix2);
    }
}
