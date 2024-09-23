package maksym.preparation.medium;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            if (valid[i]) {
                for (String word : wordDict) {
                    int j = i + word.length();
                    if (j <= n && !valid[j]) {
                        String w = s.substring(i, j);
                        valid[j] = w.equals(word);
                    }
                }
            }
        }
        return valid[n];
    }

    public static void main(String[] args) {
        WordBreak instance = new WordBreak();
        System.out.println(instance.wordBreak("applepenapple", List.of("apple", "pen")));
    }
}
