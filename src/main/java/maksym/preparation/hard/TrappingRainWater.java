package maksym.preparation.hard;

public class TrappingRainWater {

    public int trap(int[] height) {
        final int N = height.length;

        int sum = 0;

        int l = 0;
        int r = N - 1;

        int lMax = 0;
        int rMax = 0;

        while (l <= r) {
            int left = height[l];
            int right = height[r];

            lMax = Math.max(left, lMax);
            rMax = Math.max(right, rMax);

            int low = Math.min(lMax, rMax);

            if (left < right) {
                if (left < low) {
                    sum += low - left;
                }
                l++;
            } else {
                if (right < low) {
                    sum += low - right;
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
