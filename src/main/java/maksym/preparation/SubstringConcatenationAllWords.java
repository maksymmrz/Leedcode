package maksym.preparation;

import java.util.*;

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        final int totalLength = words[0].length() * words.length;
        final int wordLength = words[0].length();
        List<Integer> result = new LinkedList<>();

        Map<String, Integer> dictionary = new HashMap<>();
        Map<String, Integer> used = new HashMap<>();
        for (String word : words) {
            dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
            used.put(word, 0);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            int j = i;
            for (; j <= s.length() - wordLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                Integer max = dictionary.get(word);
                Integer left = used.get(word);

                if (max != null && left != null && max - left > 0) {
                    used.put(word, left + 1);
                } else break;
            }

            if (j == i + totalLength) {
                result.add(i);
            }
            if (i != j) {
                for (String w : words) {
                    used.put(w, 0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"bar","foo","the"};
        String str = "barfoofoobarthefoobarman";
        System.out.println(new SubstringConcatenationAllWords().findSubstring(str, words));
    }
}
