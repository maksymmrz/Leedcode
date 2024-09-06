package maksym.preparation.hard;


public class PalindromePartitioningII {
    public int minCut(String s) {
        final int n = s.length();
        boolean[][] p = new boolean[n][n];
        int[] cuts = new int[n + 1];
        cuts[0] = -1;

        for (int i = 0; i < n; i++) {
            int w = 0;
            while (i - w >= 0 && i + w < n && s.charAt(i - w) == s.charAt(i + w)) {
                p[i - w][i + w] = true;
                w++;
            }
            w = 0;
            while (i - w >= 0 && i + w + 1 < n && s.charAt(i - w) == s.charAt(i + w + 1)) {
                p[i - w][i + w + 1] = true;
                w++;
            }
            cuts[i + 1] = i;
            for (int j = 0; j <= i; j++) {
                if (p[j][i]) {
                    cuts[i + 1] = Math.min(cuts[j] + 1, cuts[i + 1]);
                }
            }
        }
        return cuts[n];
    }

    public static void main(String[] args) {
        PalindromePartitioningII instance = new PalindromePartitioningII();
        System.out.println(instance.minCut("cbbbcc"));
        System.out.println(instance.minCut("aaabb"));
    }
}
