package maksym.preparation.hard.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumFrequencyStack {

    private static class FreqStack {
        private final List<List<Integer>> valuesForFreq = new ArrayList<>();
        private final Map<Integer, Integer> frs = new HashMap<>();
        private int maxFr = 0;

        public FreqStack() {

        }

        public void push(int val) {
            int fr = frs.getOrDefault(val, 0) + 1;
            frs.put(val, fr);

            if (fr > maxFr) {
                valuesForFreq.add(new ArrayList<>());
                maxFr = fr;
            }

            valuesForFreq.get(fr - 1).add(val);
        }

        public int pop() {
            var topSt = valuesForFreq.get(maxFr - 1);
            var value = topSt.get(topSt.size() - 1);
            topSt.remove(topSt.size() - 1);

            if (topSt.isEmpty()) {
                valuesForFreq.remove(valuesForFreq.size() - 1);
                maxFr--;
            }

            int fr = frs.get(value) - 1;

            if (fr == 0) {
                frs.remove(value);
            } else {
                frs.put(value, fr);
            }

            return value;
        }
    }

    public static void main(String[] args) {
        var st = new FreqStack();

        st.push(1);
        st.push(1);
        st.push(1);
        st.push(2);
        st.push(2);

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

        st.push(2);
        System.out.println(st.pop());
    }
}
