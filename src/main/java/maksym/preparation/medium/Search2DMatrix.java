package maksym.preparation.medium;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int i = mid / n;
            int j = mid % n;

            if (matrix[i][j] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return matrix[left / n][left % n] == target;
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
