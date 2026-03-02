package maksym.preparation.hard.bsearch;

import maksym.preparation.util.Util;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.List.of;

public class SmallestRangeCoveringElementsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        final int K = nums.size();

        var pq = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));

        var minRange = new int[]{-1 << 29, 1 << 29};
        Comparator<int[]> comparator = (a, b) -> {
            var aLen = a[1] - a[0];
            var bLen = b[1] - b[0];
            return aLen != bLen ? aLen - bLen : a[0] - b[0];
        };

        var maxValue = Integer.MIN_VALUE;

        for (int k = 0; k < K; k++) {
            var value = nums.get(k).get(0);
            pq.add(new int[]{value, k, 0});
            maxValue = Math.max(value, maxValue);
        }

        var notReachedFinish = true;

        while (notReachedFinish) {
            var range = new int[]{pq.peek()[0], maxValue};

            if (comparator.compare(range, minRange) < 0) {
                minRange = range;
            }

            var elem = pq.poll();
            var k = elem[1];
            var i = elem[2] + 1;
            var arr = nums.get(k);

            if (i < arr.size()) {
                var value = arr.get(i);
                pq.offer(new int[]{value, k, i});
                maxValue = Math.max(value, maxValue);
            } else {
                notReachedFinish = false;
            }
        }

        return minRange;
    }

    public static void main(String[] args) {
        var o = new SmallestRangeCoveringElementsFromKLists();
        Util.show(o.smallestRange(of(
                of(4, 10, 15, 24, 26),
                of(0, 9, 12, 20),
                of(5, 18, 22, 30)
        )));
    }
}
