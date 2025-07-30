package maksym.preparation.medium;

public class PerfectSquares {

    public int numSquares(int n) {
        for (int c = 1; c <= n; c++) {
            if (isDivided(n, c)) {
                return c;
            }
        }

        return n;
    }

    private boolean isDivided(int n, int count) {
        int sqrt = (int) Math.sqrt(n);

        if (count == 1) {
            return sqrt * sqrt == n;
        }

        for (int i = 1; i <= sqrt; i++) {
            int m = i * i;

            if (isDivided(n - m, count - 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PerfectSquares o = new PerfectSquares();
        System.out.println(o.numSquares(13));
    }
}
