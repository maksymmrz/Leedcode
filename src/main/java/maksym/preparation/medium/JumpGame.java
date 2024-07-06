package maksym.preparation.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        int advance = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i <= advance) {
                advance = Math.max(i + nums[i], advance);
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame instance = new JumpGame();

        int[] arr1 = new int[]{2, 3, 1, 1, 4};
        System.out.println(instance.canJump(arr1));

        int[] arr2 = new int[]{3, 2, 1, 0, 4};
        System.out.println(instance.canJump(arr2));
    }
}
