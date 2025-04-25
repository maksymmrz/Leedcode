package maksym.preparation.medium.greedy;

import java.util.Arrays;

public class MaximumSwap {
    public int maximumSwap(int num) {
        final int n = Integer.toString(num).length();
        int[] s = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            s[i] = num % 10;
            num /= 10;
        }

        int[] positions = new int[11];
        Arrays.fill(positions, -1);

        for (int i = 0; i < s.length; i++) {
            int digit = s[i];
            positions[digit] = i;
        }

        for (int i = 0; i < s.length; i++) {
            int digit = s[i];

            for (int j = 9; j > digit; j--) {
                int pos = positions[j];

                if (pos > 0 && pos > i) {
                    int tmp = s[i];
                    s[i] = s[pos];
                    s[pos] = tmp;

                    i = s.length;
                    break;
                }
            }
        }

        int res = 0;

        for (int i : s) {
            res *= 10;
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSwap o = new MaximumSwap();

        System.out.println(o.maximumSwap(2736));
        System.out.println(o.maximumSwap(9973));
        System.out.println(o.maximumSwap(0));
        System.out.println(o.maximumSwap(19991));
    }
}
