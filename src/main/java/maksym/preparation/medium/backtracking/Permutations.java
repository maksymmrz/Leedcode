package maksym.preparation.medium.backtracking;

import maksym.preparation.util.Util;

import java.util.*;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        boolean[] includes = new boolean[nums.length];
        backtrack(nums, includes, new ArrayList<>(), combinations);
        return combinations;
    }

    public void backtrack(int[] nums, boolean[] included, List<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == nums.length) {
            combinations.add(new ArrayList<>(current));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!included[i]) {
                    included[i] = true;
                    current.add(nums[i]);
                    backtrack(nums, included, current, combinations);
                    current.remove(current.size() - 1);
                    included[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Permutations instance = new Permutations();
        List<List<Integer>> combinations = instance.permute(nums);

        Util.show2dList(combinations);
    }
}
