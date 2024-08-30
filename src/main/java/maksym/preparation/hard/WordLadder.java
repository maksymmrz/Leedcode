package maksym.preparation.hard;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> available = new HashSet<>(wordList);

        int passed = 0;
        boolean reached = false;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            passed++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (endWord.equals(curr)) {
                    queue.clear();
                    reached = true;
                    break;
                }

                for (int i = 0; i < curr.length(); i++) {
                    char[] chars = curr.toCharArray();
                    for (char ch = 'a'; ch <= 'z' ; ch++) {
                        chars[i] = ch;
                        String modified = String.valueOf(chars);
                        if (available.remove(modified)) {
                            queue.offer(modified);
                        }
                    }
                }
            }
        }
        return reached ? passed : 0;
    }

    public static void main(String[] args) {
        WordLadder instance = new WordLadder();
        System.out.println(instance.ladderLength("m", "n", List.of("z")));
        System.out.println(instance.ladderLength("hog", "cog", List.of("cog")));
        System.out.println(instance.ladderLength("hot", "dog", List.of("hot","cog","dog","tot","hog","hop","pot","dot")));
        System.out.println(instance.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(instance.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log")));
    }
}
