package maksym.preparation.hard.mstack;

import maksym.preparation.util.Util;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int N = nums.length;

        var ans = new int[N - k + 1];
        var deque = new LinkedList<Integer>();

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] <= nums[i]) {
                deque.pop();
            }

            if (!deque.isEmpty() && deque.peekLast() <= i - k) {
                deque.pollLast();
            }

            deque.push(i);

            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekLast()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        var o = new SlidingWindowMaximum();

        Util.show(o.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
