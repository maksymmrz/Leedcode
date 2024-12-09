package maksym.preparation.medium.dp;

public class DominoTiling {
    public int numTilings(int n) {
        final int MOD = 1_000_000_007;
        int one = 0;

        int both = 1;
        int bothPrev = 1;

        for (int i = 2; i <= n; i++) {
            int oneNext = (bothPrev + one) % MOD;
            int bothNext = ((both + bothPrev) % MOD + (2 * one) % MOD) % MOD;

            one = oneNext;
            bothPrev = both;
            both = bothNext;
        }
        return both;
    }

    public static void main(String[] args) {
        DominoTiling o = new DominoTiling();
        System.out.println(o.numTilings(3));
        System.out.println(o.numTilings(4));
        System.out.println(o.numTilings(30));
    }
}
