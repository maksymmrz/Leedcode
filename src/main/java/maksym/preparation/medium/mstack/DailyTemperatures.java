package maksym.preparation.medium.mstack;

import maksym.preparation.util.Util;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;

        int[] res = new int[n];
        Deque<int[]> st = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            int temp = temperatures[i];

            while (!st.isEmpty() && st.peek()[0] <= temp) st.pop();

            int j = st.isEmpty() ? i : st.peek()[1];

            res[i] = j - i;

            st.push(new int[]{temp, i});
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures o = new DailyTemperatures();
        Util.show(o.dailyTemperatures(new int[]{2, 1, 3, 3, 5, 4, 3, 2, 7}));
    }
}
