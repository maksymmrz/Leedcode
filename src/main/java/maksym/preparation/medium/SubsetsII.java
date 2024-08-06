package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sets = new ArrayList<>();
        gen(nums, 0, new LinkedList<>(), sets);
        return sets;
    }

    public void gen(int[] nums, int idx, Deque<Integer> stack, List<List<Integer>> sets) {
        sets.add(new ArrayList<>(stack));

        for (int i = idx; i < nums.length; i++) {
            if (i == idx || nums[i - 1] != nums[i]) {
                stack.push(nums[i]);
                gen(nums, i + 1, stack, sets);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        SubsetsII instance = new SubsetsII();
        Util.show2dList(instance.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
