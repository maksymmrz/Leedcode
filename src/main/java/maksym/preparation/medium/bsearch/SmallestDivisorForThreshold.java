package maksym.preparation.medium.bsearch;

public class SmallestDivisorForThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = 0;
        for (int n : nums) r = Math.max(n, r);


        while (l < r) {
            int div = (l + r) / 2;
            double sum = 0;

            for (int n : nums) {
                sum += Math.ceil((double) n / div);
            }

            if (sum <= threshold) r = div;
            else l = div + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        SmallestDivisorForThreshold o = new SmallestDivisorForThreshold();
        System.out.println(o.smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(o.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
    }
}
