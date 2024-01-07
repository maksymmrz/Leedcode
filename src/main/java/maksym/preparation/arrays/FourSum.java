package maksym.preparation.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        final int len = nums.length;
        List<List<Integer>> fours = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; ++i) {
            if  (i - 1 < 0 || nums[i - 1] != nums[i]) {
                for (int j = i + 1; j < len - 2; ++j) {
                    if (j - 1 == i || nums[j - 1] != nums[j]) {
                        int l = j + 1;
                        int r = len - 1;

                        while (l < r) {
                            long sum = nums[i] + (long)nums[j] + (long)nums[l] + (long)nums[r];

                            if (sum == target) {
                                fours.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                                ++l;
                                --r;
                                while (l < r && nums[l] == nums[l - 1]) ++l;
                                while (l < r && r + 1 < len && nums[r + 1] == nums[r]) --r;
                            } else if (sum < target) {
                                ++l;
                            } else {
                                --r;
                            }
                        }
                    }
                }
            }
        }
        return fours;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(new FourSum().fourSum(nums, target));
    }
}
