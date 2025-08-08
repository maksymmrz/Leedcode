package maksym.preparation.hard;

import java.util.*;

public class MaxNumberOfGroupsWithIncreasingLen {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        var sortedLimits = new ArrayList<>(usageLimits);
        sortedLimits.sort(Comparator.reverseOrder());

        int l = 0;
        int r = sortedLimits.size();

        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (passNGroups(sortedLimits, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    private boolean passNGroups(List<Integer> limits, int n) {
        int totalDelta = 0;
        int currH = n;

        for (Integer lim : limits) {
            int delta = lim - currH - totalDelta;

            if (delta >= 0) {
                totalDelta = 0;
            } else {
                totalDelta = -delta;
            }

            if (currH > 0) {
                currH--;
            }
        }

        return totalDelta == 0;
    }


    public static void main(String[] args) {
        MaxNumberOfGroupsWithIncreasingLen o = new MaxNumberOfGroupsWithIncreasingLen();
        System.out.println(o.maxIncreasingGroups(List.of(1, 1, 2, 2, 9, 10)));
        System.out.println(o.maxIncreasingGroups(List.of(1, 1, 5)));
        System.out.println(o.maxIncreasingGroups(List.of(1, 6, 2, 9)));
        System.out.println(o.maxIncreasingGroups(List.of(2, 2, 2)));
        System.out.println(o.maxIncreasingGroups(List.of(1, 2, 5)));
        System.out.println(o.maxIncreasingGroups(List.of(1, 2, 2)));
    }
}
