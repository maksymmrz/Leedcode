package maksym.preparation;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < arr[m + 1]) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) {
        PeakIndexInMountainArray instance = new PeakIndexInMountainArray();
        System.out.println(instance.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(instance.peakIndexInMountainArray(new int[]{0, 1, 6, 7, 10, 10, 5, 2}));
    }
}
