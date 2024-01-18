package maksym.preparation.easy;

import java.util.Arrays;
import java.util.stream.Stream;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String left = strs[0];
        String right = strs[strs.length - 1];
        int limit = 0;
        final int min = Math.min(left.length(), right.length());

        while (limit < min && left.charAt(limit) == right.charAt(limit)) limit++;

        return limit == 0 ? "" : left.substring(0, limit);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
}
