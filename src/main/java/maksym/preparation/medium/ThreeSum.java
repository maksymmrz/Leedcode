package maksym.preparation.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triples = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (l - 1 != i && nums[l - 1] == nums[l]) {
                        ++l;
                    } else if (r + 1 < nums.length && nums[r] == nums[r + 1]) {
                        --r;
                    } else {
                        int sum = nums[i] + nums[l] + nums[r];
                        if (sum == 0) {
                            triples.add(List.of(nums[i], nums[l], nums[r]));
                            ++l;
                            --r;
                        } else if (sum > 0) {
                            --r;
                        } else {
                            ++l;
                        }
                    }
                }

            }
        }
        return triples;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
