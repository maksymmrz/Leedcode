package maksym.preparation.easy;

public class CountNegativeInSortedMatrix {
    public int countNegatives(int[][] grid) {
        final int n = grid[0].length;
        int count = 0;
        int l = 0;
        int r = grid[0].length - 1;

        for (int[] arr : grid) {
            while (l < r) {
                int mid = (l + r) / 2;
                if (arr[mid] < 0) r = mid;
                else l = mid + 1;
            }
            if (arr[l] < 0) {
                count += n - l;
            }
            l = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        CountNegativeInSortedMatrix instance = new CountNegativeInSortedMatrix();
        int[][] m = new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(instance.countNegatives(m));
    }
}
