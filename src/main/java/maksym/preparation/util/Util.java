package maksym.preparation.util;

import java.util.List;

public class Util {
    public static <T> void show2dList(List<List<T>> lists) {
        for (List<T> combination : lists) {
            for (T e : combination) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void show2d(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
