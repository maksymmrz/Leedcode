package maksym.preparation.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int x = -1;
        int y = s.length() + 1;
        int i = 0;
        int j = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            char ch = t.charAt(k);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
        }
        int required = t.length();

        while (j < s.length() || required == 0) {
            if (required == 0) {
                if (j - i < y - x) {
                    x = i;
                    y = j;
                }
                char ch = s.charAt(i);

                Integer count = window.get(ch);
                if (count != null) {
                    count++;
                    window.put(ch, count);
                    if (count > 0) {
                        required++;
                    }
                }
                i++;
            } else {
                char ch = s.charAt(j);

                Integer count = window.get(ch);
                if (count != null) {
                    if (count > 0) {
                        required--;
                    }
                    window.put(ch, count - 1);
                }
                j++;
            }
        }
        return y - x <= s.length() ? s.substring(x, y) : "";
    }

    public static void main(String[] args) {
        MinimumWindowSubstring instance = new MinimumWindowSubstring();
        System.out.println(instance.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(instance.minWindow("a", "a"));
        System.out.println(instance.minWindow("a", "aa"));
    }
}
