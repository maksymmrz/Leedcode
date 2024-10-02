package maksym.preparation.medium;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        final int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && map.size() <= 2) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                j++;
                if (map.size() <= 2) max = Math.max(j - i, max);
            }
            while (map.size() > 2) {
                char ch = s.charAt(i);
                int count = map.get(ch);
                if (count == 1) map.remove(ch);
                else map.put(ch, count - 1);
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringAtMostTwoDistinct instance = new LongestSubstringAtMostTwoDistinct();
        System.out.println(instance.lengthOfLongestSubstringTwoDistinct("abcabc"));
    }
}
