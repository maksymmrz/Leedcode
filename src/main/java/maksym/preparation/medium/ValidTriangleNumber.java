package maksym.preparation.medium;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                k = Math.max(j, k);

                while (k + 1 < nums.length && isValid(nums[i], nums[j], nums[k + 1])) k++;
                count += k - j;
            }
        }
        return count;
    }

    private static boolean isValid(int first, int second, int third) {
        return (first + second) > third &&
                (first + third) > second &&
                (second + third) > first;
    }

    public static void main(String[] args) {
        ValidTriangleNumber o = new ValidTriangleNumber();
        System.out.println(o.triangleNumber(new int[]{1,1,3,4}));
        System.out.println(o.triangleNumber(new int[]{2,2,3,4}));
        System.out.println(o.triangleNumber(new int[]{4, 2, 3, 4}));
    }
}
