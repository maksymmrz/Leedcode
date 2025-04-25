package maksym.preparation.medium.swindow;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxVolume = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int volume = Math.min(height[left], height[right]) * (right - left);
            if (maxVolume < volume) {
                maxVolume = volume;
            }

            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return maxVolume;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 1, 2, 3, 4, 2, 1};
        System.out.println(new ContainerWithMostWater().maxArea(arr));
    }
}
