package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.*;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, boolean[] included, Deque<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
        } else {
            for (int i = 0; i < nums.length; i++) {
                boolean isDuplicate = i != 0 && nums[i - 1] == nums[i] && !included[i - 1];

                if (!included[i] && !isDuplicate) {
                    included[i] = true;
                    stack.push(nums[i]);
                    backtrack(nums, included, stack, result);
                    stack.pop();
                    included[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        PermutationsII instance = new PermutationsII();

        int[] nums1 = new int[]{1, 1, 2};
        Util.show2dList(instance.permuteUnique(nums1));

        int[] nums2 = new int[]{1, 2, 3};
        Util.show2dList(instance.permuteUnique(nums2));
    }
}
