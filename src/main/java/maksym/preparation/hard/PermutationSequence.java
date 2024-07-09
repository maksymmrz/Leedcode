package maksym.preparation.hard;


public class PermutationSequence {
    public String getPermutation(int n, int k) {
        boolean[] included = new boolean[n];
        int fact = 1;
        int div = n - 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < n; i++) fact *= i;

        k--;

        while (builder.length() < n) {
            int pos = k / fact;
            int num = 0;
            while (pos > 0 || included[num]) {
                if (!included[num]) pos--;
                num++;
            }
            included[num] = true;
            builder.append(num + 1);
            k %= fact;
            if (div > 0) {
                fact /= div;
                div--;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        PermutationSequence instance = new PermutationSequence();
        System.out.println(instance.getPermutation(3, 6));
        System.out.println(instance.getPermutation(4, 9));
    }
}
