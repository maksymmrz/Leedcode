package maksym.preparation.medium.string;

import java.util.HashMap;
import java.util.Map;

public class MaxNumOfOccurrencesOfSubstring {
    public int maxFreq(String s, int maxLetters, int minSize) {
        Map<String, Integer> countString = new HashMap<>();
        Map<Integer, Integer> included = new HashMap<>();
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            int ch = s.charAt(j);
            included.put(ch, 1 + included.getOrDefault(ch, 0));

            if (j - i + 1 == minSize) {
                if (included.size() <= maxLetters) {
                    String str = s.substring(i, j + 1);
                    countString.put(str, 1 + countString.getOrDefault(str, 0));
                }

                int last = s.charAt(i);
                int freq = included.get(last);

                if (freq == 1) included.remove(last);
                else included.put(last, freq - 1);

                i++;
            }
        }
        return countString
                .values()
                .stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static void main(String[] args) {
        MaxNumOfOccurrencesOfSubstring o = new MaxNumOfOccurrencesOfSubstring();
        System.out.println(o.maxFreq("abcd", 2, 3));
        System.out.println(o.maxFreq("aababcaab", 2, 3));
    }
}
