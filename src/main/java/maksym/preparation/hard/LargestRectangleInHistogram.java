package maksym.preparation.hard;


import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int right = 0; right <= heights.length; right++) {
            while (!stack.isEmpty() && (right == heights.length || heights[stack.peek()] >= heights[right])) {
                int h = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) width = right;
                else width = right - stack.peek() - 1;
                int area = h * width;
                max = Math.max(area, max);
            }
            stack.push(right);
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        int[] leftS = new int[heights.length];
        int[] rightS = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekFirst()] >= heights[i]) stack.pop();
            int idx = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
            leftS[i] = idx;
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekFirst()] >= heights[i]) stack.pop();
            int idx = stack.isEmpty() ? heights.length - 1 : stack.peekFirst() - 1;
            rightS[i] = idx;
            stack.push(i);
        }
        for (int i = 0; i < leftS.length; i++) {
            int area = heights[i] * (rightS[i] - leftS[i] + 1);
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram instance = new LargestRectangleInHistogram();
        System.out.println(instance.largestRectangleArea(new int[]{5,4,4,6,3,2,9,5,4,8,1,0,0,4,7,2}));
        System.out.println(instance.largestRectangleArea(new int[]{5, 4, 1, 2}));
        System.out.println(instance.largestRectangleArea(new int[]{4,2,0,3,2,4,3,4}));
        System.out.println(instance.largestRectangleArea(new int[]{2,1,2}));
    }
}
