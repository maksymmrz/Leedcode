package maksym.preparation.medium.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        final int mod = 1_000_000_007;

        int[][] ps = new int[2][5];
        Arrays.fill(ps[0], 1);

        for (int i = 1; i < n; i++) {
            ps[1][0] = ps[0][1]; // a
            ps[1][1] = (ps[0][0] + ps[0][2]) % mod; // e
            ps[1][2] = ((ps[0][0] + ps[0][1]) % mod + (ps[0][3] + ps[0][4]) % mod) % mod; // i
            ps[1][3] = (ps[0][2] + ps[0][4]) % mod; // o
            ps[1][4] = ps[0][0]; // u

            System.arraycopy(ps[1], 0, ps[0], 0, 5);
        }
        return IntStream.of(ps[0]).reduce(0, (a, b) -> (a + b) % mod);
    }

    public static void main(String[] args) {
        CountVowelsPermutation o = new CountVowelsPermutation();
        System.out.println(o.countVowelPermutation(144));
    }
}
