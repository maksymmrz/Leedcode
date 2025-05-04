package maksym.preparation.medium.sweepline;

import java.util.*;

public class MinNumberOfArrows {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int arrows = 0;
        int last = points[0][1];

        for (int[] point : points) {
            int start = point[0];
            int end = point[1];

            if (last < start) {
                arrows++;
                last = end;
            } else {
                last = Math.min(end, last);
            }
        }
        return arrows + 1;
    }

    public static void main(String[] args) {
        MinNumberOfArrows o = new MinNumberOfArrows();

        int[][] ps = new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
        System.out.println(o.findMinArrowShots(ps));
    }
}
