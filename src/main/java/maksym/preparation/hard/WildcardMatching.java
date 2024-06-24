package maksym.preparation.hard;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        boolean[][] m = new boolean[p.length() + 1][s.length() + 1];
        m[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            m[i][0] = p.charAt(i - 1) == '*' && m[i - 1][0];
        }

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == '*') {
                    m[i][j] = m[i - 1][j - 1] || m[i][j - 1] || m[i - 1][j];
                } else if (p.charAt(i - 1) == '?') {
                    m[i][j] = m[i - 1][j - 1];
                } else {
                    m[i][j] = p.charAt(i - 1) == s.charAt(j - 1) && m[i - 1][j - 1];
                }
            }
        }
        return m[p.length()][s.length()];
    }

    public static void main(String[] args) {
        String p = "*a*b*c";
        String s = "abc";
        WildcardMatching instance = new WildcardMatching();
        System.out.println(instance.isMatch(s, p));
    }
}
