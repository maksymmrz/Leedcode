package maksym.preparation.medium.backtracking;

import java.util.HashMap;
import java.util.Map;

public class PowXY {

    public double myPow(double x, int n) {
        return recPow(x, n, new HashMap<>());
    }

    public double recPow(double x, int n, Map<Integer, Double> cache) {
        if (n == 0) return 1;
        else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1.0 / x;
        } else if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int pow = n / 2;
            int remainder = n % 2;

            double first = recPow(x, pow, cache);
            cache.put(pow, first);

            double second = 1.0;
            if (remainder != 0) {
                second = recPow(x, remainder, cache);
                cache.put(remainder, second);
            }
            return first * first * second;
        }
    }

    public static void main(String[] args) {
        PowXY instance = new PowXY();
        System.out.println(instance.myPow(2, 10));
        System.out.println(instance.myPow(2, -4));
        System.out.println(instance.myPow(2, 0));
    }
}
