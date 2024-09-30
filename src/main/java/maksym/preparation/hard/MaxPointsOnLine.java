package maksym.preparation.hard;

public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;

        final double eps = 0.00001;
        int max = 1;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double x1 = points[i][0];
                double y1 = points[i][1];
                double x2 = points[j][0];
                double y2 = points[j][1];

                double tg = x1 != x2 ? (y1 - y2) / (x1 - x2) : Double.MAX_VALUE;
                double b = tg != Double.MAX_VALUE ? y1 - tg * x1 : x1;
                int counter = 0;

                for (int[] point : points) {
                    double x = point[0];
                    double y = point[1];
                    double diff = tg != Double.MAX_VALUE ? y - tg * x - b : x1 - x;
                    if (Math.abs(diff) < eps) counter++;
                }
                max = Math.max(counter, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPointsOnLine instance = new MaxPointsOnLine();
        //int[][] points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int[][] points = new int[][]{{5151,5150},{0,0},{5152,5151}};
        System.out.println(instance.maxPoints(points));
    }
}
