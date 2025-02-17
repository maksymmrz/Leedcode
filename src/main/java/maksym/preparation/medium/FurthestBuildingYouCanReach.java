package maksym.preparation.medium;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int remained = bricks;
        int right = 0;

        for (int i = 1; i < heights.length; i++) {
            int prev = heights[i - 1];
            int curr = heights[i];
            int delta = prev - curr;

            if (delta < 0) {
                pq.add(-delta);

                if (pq.size() > ladders && !pq.isEmpty()) {
                    int evicted = pq.poll();
                    remained -= evicted;
                    if (remained < 0) break;
                    else right = i;
                } else {
                    right = i;
                }
            } else {
                right = i;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach o = new FurthestBuildingYouCanReach();
        System.out.println(o.furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
        System.out.println(o.furthestBuilding(new int[]{1, 5, 1, 2, 3, 4, 10000}, 4, 1));
        System.out.println(o.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
    }
}
