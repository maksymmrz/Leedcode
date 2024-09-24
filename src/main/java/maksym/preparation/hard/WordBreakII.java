package maksym.preparation.hard;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        bt(s, 0, wordDict, new LinkedList<>(), result);
        return result;
    }

    public void bt(String s, int i, List<String> words, Deque<String> deque, List<String> result) {
        if (i == s.length()) {
            result.add(String.join(" ", deque));
        } else {
            for (String word : words) {
                int j = i + word.length();
                if (j <= s.length()) {
                    String w = s.substring(i, j);
                    if (w.equals(word)) {
                        deque.addLast(word);
                        bt(s, j, words, deque, result);
                        deque.pollLast();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII instance = new WordBreakII();
        String s = "catsanddog";
        List<String> words = List.of("cat","cats","and","sand","dog");
        System.out.println(instance.wordBreak(s, words));
    }
}
