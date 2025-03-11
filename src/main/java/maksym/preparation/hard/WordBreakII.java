package maksym.preparation.hard;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        final int n = s.length();

        Trie trie = new Trie();
        wordDict.forEach(trie::add);

        List<String> res = new ArrayList<>();

        Queue<Map.Entry<List<String>, Integer>> q = new LinkedList<>();
        q.add(Map.entry(Collections.emptyList(), 0));

        while (!q.isEmpty()) {
            Map.Entry<List<String>, Integer> entry = q.poll();
            List<String> list = entry.getKey();
            final int from = entry.getValue();

            if (from == n) {
                res.add(String.join(" ", list));
            } else {
                Trie curr = trie;

                for (int i = from; i < n; i++) {
                    int ch = s.charAt(i) - 'a';

                    curr = curr.next[ch];

                    if (curr == null) break;
                    else if (curr.hasFinish) {
                        List<String> appended = new ArrayList<>(list);
                        appended.add(s.substring(from, i + 1));
                        q.add(Map.entry(appended, i + 1));
                    }
                }
            }
        }

        return res;
    }

    private static class Trie {
        private final Trie[] next = new Trie[26];
        private boolean hasFinish = false;

        public void add(String s) {
            Trie curr = this;

            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';

                if (curr.next[ch] == null) {
                    curr.next[ch] = new Trie();
                }
                curr = curr.next[ch];
            }
            curr.hasFinish = true;
        }
    }

    public static void main(String[] args) {
        WordBreakII instance = new WordBreakII();
        String s = "catsanddog";
        List<String> words = List.of("cat","cats","and","sand","dog");
        System.out.println(instance.wordBreak(s, words));
    }
}
