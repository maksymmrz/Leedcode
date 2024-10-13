package maksym.preparation.medium.bsearch;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;

        while (l < r) {
            int m = (l + r) / 2;
            if (x - arr[m] > arr[m + k] - x) l = m + 1;
            else r = m;
        }
        return IntStream.of(arr).skip(l).limit(k).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        FindKClosestElements o = new FindKClosestElements();
        System.out.println(o.findClosestElements(new int[]{1, 1, 2, 2, 2, 2, 2, 3, 3}, 3, 3));
        System.out.println(o.findClosestElements(new int[]{-2, 1, 2, 3, 4, 5, 8, 9}, 3, 4));
    }
}
