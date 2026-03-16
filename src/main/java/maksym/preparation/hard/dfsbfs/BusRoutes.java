package maksym.preparation.hard.dfsbfs;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        var adj = new HashMap<Integer, List<Integer>>();

        for (int r = 0; r < routes.length; r++) {
            for (int station : routes[r]) {
                adj.computeIfAbsent(station, k -> new ArrayList<>()).add(r);
            }
        }

        var visitedStations = new HashSet<Integer>();
        var visitedRoutes = new HashSet<Integer>();
        var q = new ArrayDeque<Integer>();
        q.offer(source);
        visitedStations.add(source);
        var routesCount = 0;

        while (!q.isEmpty()) {
            var size = q.size();

            for (int i = 0; i < size; i++) {
                var currStation = q.poll();

                if (currStation == target) {
                    return routesCount;
                }

                for (var route : adj.getOrDefault(currStation, Collections.emptyList())) {
                    if (visitedRoutes.add(route)) {
                        for (var nextStation : routes[route]) {
                            if (visitedStations.add(nextStation)) {
                                q.offer(nextStation);
                            }
                        }
                    }
                }
            }

            routesCount++;
        }

        return -1;
    }

    public static void main(String[] args) {
        var o = new BusRoutes();
        System.out.println(o.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
    }
}
