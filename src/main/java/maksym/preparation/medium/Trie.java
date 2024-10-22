package maksym.preparation.medium;

public class Trie {

    private static final int N = 2 * 26 + 1;

    private final Trie[] tree;

    public Trie() {
        this.tree = new Trie[N];
    }

    private int toIdx(char ch) {
        if (ch < 'a') return ch - 'A';
        else return ch - 'a' + 26;
    }

    public void insert(String word) {
        if (word.isBlank()) {
            tree[N - 1] = new Trie();
        } else {
            int idx = toIdx(word.charAt(0));
            Trie child = tree[idx];
            if (child == null) {
                child = new Trie();
                tree[idx] = child;
            }
            child.insert(word.substring(1));
        }
    }

    public boolean search(String word) {
        Trie curr = this;
        int i = 0;
        while (i < word.length() && curr.tree[toIdx(word.charAt(i))] != null) curr = curr.tree[toIdx(word.charAt(i++))];
        return i == word.length() && curr.tree[N - 1] != null;
    }

    public boolean startsWith(String prefix) {
        if (prefix.isBlank()) {
            return true;
        } else {
            int idx = toIdx(prefix.charAt(0));
            Trie child = tree[idx];
            return child != null && child.startsWith(prefix.substring(1));
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        trie.insert("app");
        trie.insert("astronomy");
        trie.insert("assistance");
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.search("assistance"));
    }
}
