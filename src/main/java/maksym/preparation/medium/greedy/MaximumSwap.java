package maksym.preparation.medium.greedy;

import java.util.Arrays;

public class MaximumSwap {
    public int maximumSwap(int num) {
        final int n = Integer.toString(num).length();
        int[] s = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            s[i] = num % 10;
            num /= 10;
        }

        int[][] dp = new int[2][n + 1];
        Arrays.fill(dp[0], 0);

        for (int j =  n - 1; j >= 0; j--) {
            if (s[j] <= dp[0][j + 1]) {
                dp[0][j] = dp[0][j + 1];
                dp[1][j] = dp[1][j + 1];
            } else {
                dp[0][j] = s[j];
                dp[1][j] = j;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s[i] < dp[0][i + 1]) {
                int j = dp[1][i + 1];
                int tmp = s[i];

                s[i] = dp[0][i + 1];
                s[j] = tmp;
                break;
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            res *= 10;
            res += s[i];
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumSwap o = new MaximumSwap();

        System.out.println(o.maximumSwap(2736));
        System.out.println(o.maximumSwap(9973));
        System.out.println(o.maximumSwap(0));
        System.out.println(o.maximumSwap(19991));
    }
}
