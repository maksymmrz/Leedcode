package maksym.preparation.medium;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int len = 1; len <= n; len++) {

            for (int i = 0; i <= len - 1; i++) {
                int left = dp[len - 1 - i];
                int right = dp[i];
                dp[len] += left * right;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
        System.out.println(instance.numTrees(3));
    }
}
