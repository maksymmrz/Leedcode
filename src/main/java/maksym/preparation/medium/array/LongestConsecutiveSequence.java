package maksym.preparation.medium.array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        var max = 0;

        for (int num : nums) {
            var size = 1;

            var left = num - 1;

            while (set.remove(left)) {
                left--;
                size++;
            }

            var right = num + 1;

            while (set.remove(right)) {
                right++;
                size++;
            }

            max = Math.max(size, max);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence instance = new LongestConsecutiveSequence();
        System.out.println(instance.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
