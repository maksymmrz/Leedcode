package maksym.preparation.hard;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int lmax = 0;
        int rmax = 0;
        int sum = 0;

        while (l < r) {
            lmax = Math.max(height[l], lmax);
            rmax = Math.max(height[r], rmax);

            if (height[l] < height[r]) {
                sum += Math.min(lmax, rmax) - height[l];
                l++;
            } else {
                sum += Math.min(lmax, rmax) - height[r];
                r--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater instance = new TrappingRainWater();
        System.out.println(instance.trap(arr));
    }
}
