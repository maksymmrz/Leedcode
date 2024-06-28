package maksym.preparation.medium;

public class JumpGameII {

    public int jump(int[] nums) {
        int steps = 0;
        int i = 0;

        while (i < nums.length - 1) {
            int jump = i;
            int from = i + 1;

            if (i + nums[i] < nums.length - 1) {
                for (int j = from; j <= i + nums[i]; j++) {
                    if (jump < nums[j] + j) {
                        jump = nums[j] + j;
                        from = j;
                    }
                }
                i = from;
            } else {
                i = nums.length - 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGameII instance = new JumpGameII();

        int[] nums1 = new int[]{2, 3, 1, 1, 4};
        System.out.println(instance.jump(nums1) == 2);

        int[] nums2 = new int[]{2, 3, 0, 1, 4};
        System.out.println(instance.jump(nums2) == 2);

        int[] nums3 = new int[]{1, 2, 1, 1, 1};
        System.out.println(instance.jump(nums3) == 3);
    }
}
