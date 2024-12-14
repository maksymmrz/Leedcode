package maksym.preparation.medium.bsearch;

public class MinimumSpeedToArrive {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10_000_000;

        while (low < high) {
            int speed = (low + high) / 2;
            double time = time(dist, speed);

            if (time <= hour) high = speed;
            else low = speed + 1;
        }

        double time = time(dist, low);
        if (time <= hour) return low;
        else return -1;
    }

    private double time(int[] dist, double speed) {
        double time = 0;

        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil(dist[i] / speed);
        }
        if (dist.length > 0) {
            time += dist[dist.length - 1] / speed;
        }
        return time;
    }

    public static void main(String[] args) {
        MinimumSpeedToArrive o = new MinimumSpeedToArrive();
        System.out.println(o.minSpeedOnTime(new int[]{6, 10, 5, 1, 8, 9, 2}, 34.01));
        System.out.println(o.minSpeedOnTime(new int[]{1, 1, 100000}, 2.01));
        System.out.println(o.minSpeedOnTime(new int[]{1, 3, 2}, 2.7));
        System.out.println(o.minSpeedOnTime(new int[]{1, 3, 2}, 1.9));
    }
}
