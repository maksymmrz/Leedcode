package maksym.preparation.medium.bsearch;

public class MaxValueAtGivenIndex {
    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (isValidCondition(mid, n, index, maxSum)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean isValidCondition(long value, int n, int i, int maxSum) {
        long sum = value + n - 1;
        final long side = value - 2;

        if (i + side < n) {
            sum += (side * side + side) / 2;
        } else {
            long h = n - i - 1;
            sum += h * ((side - h + 1) + side) / 2;
        }

        if (side <= i) {
            sum += (side * side + side) / 2;
        } else {
            sum += i * (side + (side - i + 1)) / 2;
        }
        return sum <= maxSum;
    }

    public static void main(String[] args) {
        MaxValueAtGivenIndex o = new MaxValueAtGivenIndex();
        System.out.println(o.maxValue(5, 0, 28));
        System.out.println(o.maxValue(4, 0, 4));
        System.out.println(o.maxValue(3, 2, 18));
    }
}
