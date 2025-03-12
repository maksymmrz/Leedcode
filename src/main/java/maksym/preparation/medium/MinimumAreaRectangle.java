package maksym.preparation.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        final int n = points.length;

        Set<Map.Entry<Integer, Integer>> set = Stream.of(points)
                .map(p -> Map.entry(p[0], p[1]))
                .collect(Collectors.toSet());

        int maxArea = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (x1 != x2 && y1 != y2) {

                    if (set.contains(Map.entry(x1, y2)) && set.contains(Map.entry(x2, y1))) {
                        int area = Math.abs((x1 - x2) * (y1 - y2));
                        maxArea = Math.min(area, maxArea);
                    }
                }
            }
        }
        return maxArea == Integer.MAX_VALUE ? 0 : maxArea;
    }

    public static void main(String[] args) {
        MinimumAreaRectangle o = new MinimumAreaRectangle();

        int[][] ps = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}};
        System.out.println(o.minAreaRect(ps));
    }
}
