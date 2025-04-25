package maksym.preparation.medium.backtracking;

import maksym.preparation.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, n, k, result);
        return result;
    }

    public void backtrack(List<Integer> combination, int curr, int n, int k, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
        } else {
            for (int i = curr; i <= n - k + 1; i++) {
                combination.add(i);
                backtrack(combination, i + 1, n, k - 1, result);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations instance = new Combinations();

        Util.show2dList(instance.combine(4, 2));
    }
}
