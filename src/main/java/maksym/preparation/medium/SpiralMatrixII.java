package maksym.preparation.medium;

import maksym.preparation.util.Util;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int i = 0;
        int j = 0;
        int lim = 0;
        int[][] matrix = new int[n][n];
        int counter = 1;

        while (lim < (n + 1) / 2) {

            while (j < n - lim) {
                matrix[i][j] = counter++;
                if (j != n - lim - 1) j++;
                else break;
            }
            i++;

            while (i < n - lim) {
                matrix[i][j] = counter++;
                if (i != n - lim - 1) i++;
                else break;
            }
            j--;

            while (j >= lim) {
                matrix[i][j] = counter++;
                if (j != lim) j--;
                else break;
            }
            i--;

            while (i > lim) {
                matrix[i][j] = counter++;
                if (i != lim + 1) i--;
                else break;
            }
            j++;

            lim++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixII instance = new SpiralMatrixII();
        Util.show2d(instance.generateMatrix(4));
    }
}
