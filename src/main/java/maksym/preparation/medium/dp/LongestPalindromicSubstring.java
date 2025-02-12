package maksym.preparation.medium.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        StringBuilder builder = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i)).append('#');
        }

        String ns = builder.toString();
        final int n = ns.length();

        int[] p = new int[n];
        int len = 0;
        int start = 0;

        int l = 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            if (i < r) {
                int mirror = l + (r - i);
                p[i] = Math.min(p[mirror], r - i);
            }

            while (i + p[i] + 1 < n
                    &&  i - p[i] - 1 >= 0
                    && ns.charAt(i - p[i] - 1) == ns.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            if (i + p[i] > r) {
                r = i + p[i];
                l = i - p[i];
            }

            if (len < (r - l + 1) / 2) {
                len = (r - l + 1) / 2;
                start = l / 2;
            }
        }
        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring o = new LongestPalindromicSubstring();
        System.out.println(o.longestPalindrome("babad"));
    }
}
