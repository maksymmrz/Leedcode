package maksym.preparation.medium;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(candidates, 0, target, new LinkedList<>(), combinations);
        return combinations;
    }

    public void backtrack(int[] candidates, int from, int remain, Deque<Integer> list, List<List<Integer>> combinations) {
        if (remain == 0) {
            combinations.add(new ArrayList<>(list));
        } else if (remain > 0) {
            for (int i = from; i < candidates.length; i++) {
                int current = candidates[i];
                list.push(current);
                backtrack(candidates, i, remain - current, list, combinations);
                list.pop();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum instance = new CombinationSum();
        int[] input1 = new int[]{4,2,8};
        List<List<Integer>> combinations = instance.combinationSum(input1, 8);
        for (List<Integer> combination : combinations) {
            for (Integer i : combination) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
