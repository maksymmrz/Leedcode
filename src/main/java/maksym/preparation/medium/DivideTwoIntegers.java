package maksym.preparation.medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean negative = dividend < 0 ^ divisor < 0;

        if (dividend == Integer.MIN_VALUE)
            if (divisor == 1) return Integer.MIN_VALUE;
            else if (divisor == -1) return Integer.MAX_VALUE;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;

        while (dividend - divisor >= 0) {
            int shift = 0;
            while (dividend - (divisor << shift) >= 0) shift++;
            int part = 1 << (shift - 1);
            dividend -= divisor << (shift - 1);
            result += part;
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(Integer.MIN_VALUE, -1));
    }
}
