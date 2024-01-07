package maksym.preparation;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringExRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            int max = 1;
            int l = 0;
            int r = 1;

            Set<Character> used = new HashSet<>();
            used.add(s.charAt(0));

            while (l <= r && r < s.length()) {
                if (used.add(s.charAt(r)) || l == r) {
                    max = Math.max(max, r - l + 1);
                    ++r;
                } else {
                    used.remove(s.charAt(l));
                    ++l;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringExRepeatingChars().lengthOfLongestSubstring("pwwkew"));
    }
}
