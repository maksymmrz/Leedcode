package maksym.preparation.medium.twopointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int left = height[l];
            int right = height[r];

            int len = r - l;
            int h = Math.min(left, right);

            maxArea = Math.max(len * h, maxArea);

            if (left < right) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(arr));
    }
}
