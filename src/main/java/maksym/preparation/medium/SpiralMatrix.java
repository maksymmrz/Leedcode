package maksym.preparation.medium;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;

        List<Integer> seq = new LinkedList<>();

        int i = 0;
        int j = 0;
        int lim = 0;

        while (i < n - lim && j < m - lim) {

            while (j < m - lim) {
                seq.add(matrix[i][j]);
                if (j == m - lim - 1) break;
                else j++;
            }
            i++;
            if (i >= n - lim) break;
            while (i < n - lim) {
                seq.add(matrix[i][j]);
                if (i == n - lim - 1) break;
                else i++;
            }
            j--;
            if (j < lim) break;
            while (j >= lim) {
                seq.add(matrix[i][j]);
                if (j == lim) break;
                else j--;
            }
            i--;
            if (i <= lim) break;
            while (i > lim) {
                seq.add(matrix[i][j]);
                if (i == lim + 1) break;
                else i--;
            }
            j++;
            lim++;
        }
        return seq;
    }

    public static void main(String[] args) {
        SpiralMatrix instance = new SpiralMatrix();

        int[][] m1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(instance.spiralOrder(m1));

        int[][] m2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(instance.spiralOrder(m2));

        int[][] m3 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(instance.spiralOrder(m3));
    }
}
