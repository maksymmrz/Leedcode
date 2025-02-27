package maksym.preparation.medium.string;

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for (String root : dictionary) {
            trie.insert(root);
        }

        StringBuilder builder = new StringBuilder();

        for (String word : sentence.split(" ")) {
            if (builder.length() != 0) {
                builder.append(' ');
            }

            int i = trie.findPrefix(word);
            if (i != -1) {
                builder.append(word, 0, i);
            } else {
                builder.append(word);
            }
        }

        return builder.toString();
    }

    private static class Trie {
        private final Trie[] children = new Trie[26];
        private boolean isEnd = false;

        public int findPrefix(String s) {
            return findPrefix(s, 0);
        }

        private int findPrefix(String s, int i) {
            if (i == s.length() || isEnd) {
                return isEnd ? i : -1;
            } else {
                int ch = s.charAt(i) - 'a';
                return children[ch] != null ? children[ch].findPrefix(s, i + 1) : -1;
            }
        }

        public void insert(String s) {
            insert(s, 0);
        }

        private void insert(String s, int i) {
            if (i == s.length()) {
                this.isEnd = true;
            } else {
                int ch = s.charAt(i) - 'a';
                if (children[ch] == null) {
                    children[ch] = new Trie();
                }
                children[ch].insert(s, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        ReplaceWords o = new ReplaceWords();

        List<String> roots = List.of("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";

        System.out.println(o.replaceWords(roots, sentence));
    }
}
