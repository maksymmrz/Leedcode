package main.java.person.maksym.preparation;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        final int n = s.length() + 1;
        final int m = p.length() + 1;
        boolean[][] matrix = new boolean[n][m];

        matrix[0][0] = true;
        for (int j = 0; j < m - 1; ++j) {
            matrix[0][j + 1] = p.charAt(j) == '*' && matrix[0][j - 1];
        }

        for(int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (p.charAt(j - 1) == '*') {
                    matrix[i][j] =
                            ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') &&
                                    (matrix[i][j - 1] || matrix[i - 1][j - 1] || matrix[i - 1][j]))
                            || matrix[i][j - 2];
                } else if (p.charAt(j - 1) == '.') {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && matrix[i - 1][j - 1];
                }
            }
        }
        return matrix[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("a", ".*."));
    }
}
