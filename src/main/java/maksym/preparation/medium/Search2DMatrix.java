package maksym.preparation.medium;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final int N = m * n;

        int l = 0;
        int r = N - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] < target) l = mid + 1;
            else r = mid;
        }
        return matrix[l / n][l % n] == target;
    }

    public static void main(String[] args) {
        Search2DMatrix instance = new Search2DMatrix();

        int[][] matrix = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        System.out.println(instance.searchMatrix(matrix, 3));
    }
}
