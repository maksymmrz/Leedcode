package maksym.preparation.medium.trie;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int n = s.length();

        Trie trie = new Trie();
        wordDict.forEach(trie::add);

        boolean[] valid = new boolean[n + 1];
        valid[0] = true;

        for (int i = 0; i < n; i++) {
            Trie curr = trie;
            if (valid[i]) {
                for (int j = i; j < n; j++) {
                    int ch = s.charAt(j) - 'a';
                    curr = curr.next[ch];

                    if (curr == null) break;
                    if (curr.hasEnd) valid[j + 1] = true;
                }
            }
        }
        return valid[n];
    }

    private static class Trie {
        private final Trie[] next = new Trie[26];
        private boolean hasEnd = false;

        public void add(String s) {
            Trie curr = this;

            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';

                if (curr.next[ch] == null) {
                    curr.next[ch] = new Trie();
                }

                curr = curr.next[ch];
            }
            curr.hasEnd = true;
        }
    }

    public static void main(String[] args) {
        WordBreak instance = new WordBreak();
        System.out.println(instance.wordBreak("applepenapple", List.of("apple", "pen")));
    }
}
