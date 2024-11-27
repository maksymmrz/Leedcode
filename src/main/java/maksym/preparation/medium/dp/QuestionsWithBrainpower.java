package maksym.preparation.medium.dp;

public class QuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        final int N = questions.length;
        long[] dp = new long[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }

            int points = questions[i][0];
            int bp = questions[i][1];

            int j = i + bp + 1;
            if (j < N) {
                dp[j] = Math.max(dp[i] + points, dp[j]);
            }
            max = Math.max(dp[i] + points, max);
        }
        return max;
    }

    public static void main(String[] args) {
        QuestionsWithBrainpower o = new QuestionsWithBrainpower();
        int[][] qs = new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}};
        System.out.println(o.mostPoints(qs));
    }
}
