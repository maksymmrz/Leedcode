package maksym.preparation.medium.bsearch;

public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
        int l = 0;
        int r = 0;

        for (int e : ribbons) {
            r = Math.max(e, r);
        }

        while (l < r) {
            int m = (l + r + 1) / 2;

            if (isAnswer(ribbons, k, m)) l = m;
            else r = m - 1;
        }

        return l;
    }

    private boolean isAnswer(int[] arr, int k, int target) {
        int count = 0;

        for (int e : arr) {
            count += e / target;
        }

        return count >= k;
    }

    public static void main(String[] args) {
        CuttingRibbons o = new CuttingRibbons();
        System.out.println(o.maxLength(new int[]{7, 5, 9}, 4));
    }
}
