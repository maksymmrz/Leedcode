package maksym.preparation.hard.twopointers;

public class TrappingRainWater {

    public int trap(int[] height) {
        final int N = height.length;

        if (N < 3) {
            return 0;
        }

        int l = 0;
        int r = N - 1;

        int leftMax = 0;
        int rightMax = 0;

        int sum = 0;

        while (l <= r) {
            int left = height[l];
            int right = height[r];

            leftMax = Math.max(left, leftMax);
            rightMax = Math.max(right, rightMax);

            int h = Math.min(leftMax, rightMax);

            if (left < right) {
                if (left < h) {
                    sum += h - left;
                }

                l++;
            } else {
                if (right < h) {
                    sum += h - right;
                }

                r--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater instance = new TrappingRainWater();
        System.out.println(instance.trap(arr));
    }
}
