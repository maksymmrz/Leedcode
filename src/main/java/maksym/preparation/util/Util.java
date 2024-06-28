package maksym.preparation.util;

import java.util.List;

public class Util {
    public static void show2dList(List<List<Integer>> lists) {
        for (List<Integer> combination : lists) {
            for (Integer i : combination) {
                System.out.print(i + " ");
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
    }
}
