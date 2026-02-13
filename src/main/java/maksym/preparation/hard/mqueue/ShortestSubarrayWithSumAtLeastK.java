package maksym.preparation.hard.mqueue;

import java.util.LinkedList;

public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        var minLen = Long.MAX_VALUE;

        var currentPrefix = 0L;
        var deque = new LinkedList<long[]>();

        for (int i = 0; i < nums.length; i++) {
            currentPrefix += nums[i];

            if (currentPrefix >= k) {
                minLen = Math.min(i + 1, minLen);
            }

            while (!deque.isEmpty() && currentPrefix - deque.peekLast()[0] >= k) {
                final var pos = deque.pollLast()[1];
                minLen = Math.min(i - pos, minLen);
            }

            while (!deque.isEmpty() && deque.peekFirst()[0] > currentPrefix) {
                deque.pollFirst();
            }

            deque.addFirst(new long[]{currentPrefix, i});
        }

        return minLen < Long.MAX_VALUE ? (int) minLen : -1;
    }

    public static void main(String[] args) {
        var o = new ShortestSubarrayWithSumAtLeastK();
        System.out.println(o.shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167));
        System.out.println(o.shortestSubarray(new int[]{2, -1, 2}, 3));
    }
}
