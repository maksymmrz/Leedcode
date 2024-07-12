package maksym.preparation.medium;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        int[][] d = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) d[i][j] = j;
                else if (j == 0) d[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    int upper = d[i - 1][j];
                    int corner = d[i - 1][j - 1];
                    int left = d[i][j - 1];

                    d[i][j] = 1 + Math.min(upper, Math.min(corner, left));
                }
            }
        }
        return d[m][n];
    }

    public int minDistanceMemoryOptimisation(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        int[] d = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) d[j] = j;
                else if (j == 0) d[0] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    d[j] = p[j - 1];
                } else {
                    int upper = p[j];
                    int corner = p[j - 1];
                    int left = d[j - 1];

                    d[j] = 1 + Math.min(upper, Math.min(corner, left));
                }
            }
            System.arraycopy(d, 0, p, 0, n + 1);
        }
        return d[n];
    }

    public static void main(String[] args) {
        EditDistance instance = new EditDistance();

        System.out.println(instance.minDistanceMemoryOptimisation("wo1rd12", "word"));
        System.out.println(instance.minDistance("wo1rd12", "word"));
    }
}
