package maksym.preparation.medium.array;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;

        var seq = new LinkedList<Integer>();

        var up = 0;
        var down = M - 1;
        var left = 0;
        var right = N - 1;

        while (seq.size() < M * N) {
            for (int j = left; j <= right; j++) {
                seq.add(matrix[up][j]);
            }

            for (int i = up + 1; i <= down; i++) {
                seq.add(matrix[i][right]);
            }

            if (up != down) {
                for (int j = right - 1; j >= left; j--) {
                    seq.add(matrix[down][j]);
                }
            }

            if (left != right) {
                for (int i = down - 1; i > up; i--) {
                    seq.add(matrix[i][left]);
                }
            }
            up++;
            down--;
            right--;
            left++;
        }
        return seq;
    }

    public static void main(String[] args) {
        SpiralMatrix instance = new SpiralMatrix();

        int[][] m1 = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        System.out.println(instance.spiralOrder(m1));

        int[][] m2 = new int[][]{
                {1},
                {2},
                {3},
                {4}
        };
        System.out.println(instance.spiralOrder(m2));

        int[][] m3 = new int[][]{
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };
        System.out.println(instance.spiralOrder(m3));
    }
}
