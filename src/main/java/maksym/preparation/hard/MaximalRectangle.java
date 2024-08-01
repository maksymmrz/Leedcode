package maksym.preparation.hard;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        int[] histogram = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    histogram[j]++;
                } else {
                    histogram[j] = 0;
                }
            }
            int currentMaxArea = maxRectangle(histogram);
            maxArea = Math.max(currentMaxArea, maxArea);
        }
        return maxArea;
    }

    public int maxRectangle(int[] histogram) {
        Deque<Integer> stack = new LinkedList<>();
        int max = 0;

        for (int right = 0; right <= histogram.length; right++) {
            while (!stack.isEmpty() && (right == histogram.length || histogram[stack.peek()] >= histogram[right])) {
                int mid = stack.pop();
                int h = histogram[mid];
                int width = stack.isEmpty() ? right : right - stack.peek() - 1;
                int area = h * width;
                max = Math.max(area, max);
            }
            stack.push(right);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle instance = new MaximalRectangle();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(instance.maximalRectangle(matrix));

        System.out.println(instance.maxRectangle(new int[]{5, 4, 4, 6, 3, 2, 9, 5, 4, 8, 1, 0, 0, 4, 7, 2}));
    }
}
