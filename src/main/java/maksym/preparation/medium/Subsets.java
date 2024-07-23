package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), sets);
        return sets;
    }

    public void backtrack(int[] nums, int idx, ArrayList<Integer> current, List<List<Integer>> sets) {
        if (idx == nums.length) {
            sets.add(new ArrayList<>(current));
        } else {
            current.add(nums[idx]);
            backtrack(nums, idx + 1, current, sets);
            current.remove(current.size() - 1);

            backtrack(nums, idx + 1, current, sets);
        }
    }

    public static void main(String[] args) {
        Subsets instance = new Subsets();

        Util.show2dList(instance.subsets(new int[]{1, 2, 3, 4}));
    }
}
