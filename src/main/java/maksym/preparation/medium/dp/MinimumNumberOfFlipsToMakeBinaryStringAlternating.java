package maksym.preparation.medium.dp;

public class MinimumNumberOfFlipsToMakeBinaryStringAlternating {
    public int minFlips(String s) {
        final int N = s.length();
        int[] evenPrefix = new int[N + 1]; // =>
        int[] oddPrefix = new int[N + 1]; // <=

        int odd = 0;
        int even = 0;

        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);

            if (ch == '1') {
                if (i % 2 == 0) even++;
                else odd++;
            } else {
                if (i % 2 == 0) odd++;
                else even++;
            }

            evenPrefix[i + 1] = even;
            oddPrefix[i + 1] = odd;
        }

        odd = 0;
        even = 0;
        int[] evenSuffix = new int[N + 1];
        int[] oddSuffix = new int[N + 1];

        for (int i = N - 1; i >= 0; i--) {
            int j = N - i - 1;
            char curr = s.charAt(i);

            if (curr == '1') {
                if (j % 2 == 0) even++;
                else odd++;
            } else {
                if (j % 2 == 0) odd++;
                else even++;
            }

            evenSuffix[i] = even;
            oddSuffix[i] = odd;
        }

        var min = Math.min(even, odd);

        for (int i = 0; i < N; i++) {
            var first = evenPrefix[i + 1] + oddSuffix[i + 1];
            var second = oddPrefix[i + 1] + evenSuffix[i + 1];
            var split = Math.min(first, second);

            min = Math.min(split, min);
        }

        return min;
    }

    public static void main(String[] args) {
        var o = new MinimumNumberOfFlipsToMakeBinaryStringAlternating();
        System.out.println(o.minFlips("01001001101"));
    }
}
