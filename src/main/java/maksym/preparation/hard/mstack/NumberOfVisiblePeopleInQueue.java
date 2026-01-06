package maksym.preparation.hard.mstack;

import maksym.preparation.util.Util;

import java.util.LinkedList;

public class NumberOfVisiblePeopleInQueue {
    public int[] canSeePersonsCount(int[] heights) {
        final var N = heights.length;
        var st = new LinkedList<Integer>();

        var visible = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            var h = heights[i];

            var count = 0;

            while (!st.isEmpty() && st.peek() < h) {
                st.pop();
                count++;
            }

            if (!st.isEmpty()) {
                count++;
            }

            visible[i] = count;

            st.push(h);
        }

        return visible;
    }

    public static void main(String[] args) {
        var o = new NumberOfVisiblePeopleInQueue();
        Util.show(o.canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9}));
    }
}
