package maksym.preparation.medium;

public class HIndexII {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int h = n - m;
            if (h > citations[m]) l = l + 1;
            else r = m - 1;
        }
        return n - l;
    }

    public static void main(String[] args) {
        HIndexII instance = new HIndexII();
        System.out.println(instance.hIndex(new int[]{0}));
        System.out.println(instance.hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(instance.hIndex(new int[]{0, 1, 3, 4, 5, 6}));
    }
}
