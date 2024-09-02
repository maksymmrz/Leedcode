package maksym.preparation.medium;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());

        for (int num : nums) {
            int len = 1;
            int left = num - 1;
            while (set.remove(left)) {
                len++;
                left--;
            }

            int right = num + 1;
            while (set.remove(right)) {
                len++;
                right++;
            }

            max = Math.max(len, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence instance = new LongestConsecutiveSequence();
        System.out.println(instance.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
