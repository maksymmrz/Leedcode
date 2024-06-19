package maksym.preparation.medium.backtracking;

import maksym.preparation.util.Util;

import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new LinkedList<>();
        Deque<Integer> buffer = new LinkedList<>();
        backtrack(candidates, 0, target, buffer, combinations);
        return new ArrayList<>(combinations);
    }

    public void backtrack(int[] candidates, int idx, int remain, Deque<Integer> buffer, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(buffer));
        } else if (remain > 0) {
            for (int i = idx; i < candidates.length; i++) {
                if (remain - candidates[i] < 0) break;
                if (i == idx || candidates[i - 1] != candidates[i]) {
                    buffer.push(candidates[i]);
                    backtrack(candidates, i + 1, remain - candidates[i], buffer, result);
                    buffer.pop();
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,7,6,1,5};
        CombinationSumII instance = new CombinationSumII();
        List<List<Integer>> result = instance.combinationSum2(arr, 8);
        Util.show2dList(result);
    }
}
