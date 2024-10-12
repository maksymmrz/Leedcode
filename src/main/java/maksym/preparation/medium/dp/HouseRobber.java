package maksym.preparation.medium.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        int f1 = 0;
        int g1 = 0;

        for (int num : nums) {
            int f = num + g1;
            int g = Math.max(g1, f1);
            f1 = f;
            g1 = g;
        }
        return Math.max(f1, g1);
    }

    public static void main(String[] args) {
        HouseRobber o = new HouseRobber();
        System.out.println(o.rob(new int[]{1, 7, 1, 1, 2}));
    }
}
