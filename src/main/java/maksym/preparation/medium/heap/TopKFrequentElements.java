package maksym.preparation.medium.heap;

import maksym.preparation.util.Util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencies = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencies.put(n, 1 + frequencies.getOrDefault(n, 0));
        }

        var tops = new PriorityQueue<Map.Entry<Integer, Integer>>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            tops.add(entry);

            if (tops.size() > k) {
                tops.poll();
            }
        }

        return tops.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        var o = new TopKFrequentElements();

        var arr = new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2};

        Util.show(o.topKFrequent(arr, 2));
    }
}
