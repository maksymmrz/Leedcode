package maksym.preparation.medium.ranges;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int[] trip : trips) {
            start = Math.min(trip[1], start);
            end = Math.max(trip[2], end);
        }

        int n = end - start + 1;
        int[] p = new int[n];

        for (int[] trip : trips) {
            int num = trip[0];
            int s = trip[1] - start;
            int e = trip[2] - start;

            p[s] += num;
            p[e] -= num;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                p[i] += p[i - 1];
            }

            if (p[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling o = new CarPooling();
        System.out.println(o.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
        System.out.println(o.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }
}
