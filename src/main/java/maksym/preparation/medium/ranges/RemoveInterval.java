package maksym.preparation.medium.ranges;

import java.util.*;

public class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        final int left = toBeRemoved[0];
        final int right = toBeRemoved[1];

        List<List<Integer>> acc = new LinkedList<>();

        for (int[] range : intervals) {
            int start = range[0];
            int end = range[1];

            if (end <= left || start >= right) {
                acc.add(List.of(start, end));
            } else {
                if (start < left && end > right) {
                    acc.add(List.of(start, left));
                    acc.add(List.of(right, end));
                } else if (start < left) {
                    acc.add(List.of(start, left));
                } else if (end > right) {
                    acc.add(List.of(right, end));
                }
            }
        }
        return acc;
    }

    public static void main(String[] args) {
        RemoveInterval o = new RemoveInterval();

        int[][] ranges = new int[][]{{0, 2}, {3, 4}, {5, 7}};
        int[] toRemove = new int[]{1, 6};

        System.out.println(o.removeInterval(ranges, toRemove));
    }
}
