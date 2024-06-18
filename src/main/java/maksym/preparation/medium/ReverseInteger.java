package maksym.preparation.medium;

public class ReverseInteger {

    public int reverse(int x) {
        int number = x;
        long revers = 0;

        while (number != 0) {
            if (number != x) {
                revers *= 10;
            }
            revers += (number % 10);
            number /= 10;
        }
        if (revers > Integer.MAX_VALUE || revers < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) revers;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-123456));
    }
}
