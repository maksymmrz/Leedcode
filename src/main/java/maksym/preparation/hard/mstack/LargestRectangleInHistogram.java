package maksym.preparation.hard.mstack;

import java.util.LinkedList;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        var st = new LinkedList<Integer>();
        var maxArea = 0;

        for (int right = 0; right <= heights.length; right++) {
            var currHeight = right < heights.length ? heights[right] : 0;

            while (!st.isEmpty() && heights[st.peek()] > currHeight) {
                var idx = st.pop();
                var h = heights[idx];
                var area = 0;

                if (st.isEmpty()) {
                    area = h * right;
                } else {
                    area = h * (right - st.peek() - 1);
                }

                maxArea = Math.max(area, maxArea);
            }
            st.push(right);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        System.out.println(instance.largestRectangleArea(new int[]{1, 2, 3}));
        System.out.println(instance.largestRectangleArea(new int[]{0, 3, 2, 4, 3, 4}));
        System.out.println(instance.largestRectangleArea(new int[]{2, 1, 2}));
    }
}
