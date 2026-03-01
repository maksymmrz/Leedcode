package maksym.preparation.medium.trie;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        final var N = s.length();
        var trie = new Trie();

        for (String w : wordDict) {
            trie.addWord(w);
        }

        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;

        for (int i = 0; i < N; i++) {
            if (valid[i]) {
                var pos = trie;

                for (int j = i; j < N; j++) {
                    char curr = s.charAt(j);
                    var next = pos.refs.get(curr);
                    if (next == null) break;

                    if (next.isEnd) {
                        valid[j + 1] = true;
                    }
                    pos = next;
                }
            }
        }

        return valid[N];
    }

    private static class Trie {
        public Map<Character, Trie> refs = new HashMap<>();
        public boolean isEnd = false;

        public void addWord(String s) {
            addWord(s, 0);
        }

        private void addWord(String s, int i) {
            if (i == s.length()) {
                isEnd = true;
            } else {
                refs.computeIfAbsent(s.charAt(i), k -> new Trie()).addWord(s, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        WordBreak instance = new WordBreak();
        System.out.println(instance.wordBreak("applepenapple", List.of("apple", "pen")));
    }
}
