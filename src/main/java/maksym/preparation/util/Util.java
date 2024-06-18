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
}
