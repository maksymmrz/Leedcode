package maksym.preparation.hard.dp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        var dist = startFuel;
        var usedStations = 0;

        for (int[] station : stations) {
            var currLocation = station[0];
            var gas = station[1];

            while (dist < currLocation && !pq.isEmpty()) {
                dist += pq.poll();
                usedStations++;
            }

            if (dist < currLocation) {
                break;
            }

            pq.offer(gas);
        }

        while (dist < target && !pq.isEmpty()) {
            dist += pq.poll();
            usedStations++;
        }

        return target <= dist ? usedStations : -1;
    }

    public int minRefuelStopsDP(int target, int startFuel, int[][] stations) {
        final int N = stations.length;
        int[] dp = new int[N + 1];

        dp[0] = startFuel;

        for (int s = 0; s < N; s++) {
            var point = stations[s][0];
            var fuel = stations[s][1];

            for (int i = s + 1; i > 0; i--) {
                var prevDist = dp[i - 1];

                if (point <= prevDist) {
                    var nextDist = prevDist + fuel;

                    dp[i] = Math.max(nextDist, dp[i]);
                }
            }
        }

        for (int s = 0; s <= N; s++) {
            if (dp[s] >= target) {
                return s;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var o = new MinimumNumberOfRefuelingStops();
        System.out.println(o.minRefuelStops(100, 10, new int[][]{{10, 60}}));
        System.out.println(o.minRefuelStopsDP(100, 10, new int[][]{{10, 60}}));
        System.out.println(o.minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
        System.out.println(o.minRefuelStopsDP(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
    }
}
