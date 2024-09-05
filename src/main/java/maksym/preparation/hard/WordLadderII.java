package maksym.preparation.hard;

import maksym.preparation.util.Util;

import java.util.*;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();

        Set<String> available = new HashSet<>(wordList);
        Map<String, Integer> distances = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        if (available.contains(endWord)) queue.offer(beginWord);
        available.remove(beginWord);
        int layers = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            layers++;

            for (int k = 0; k < size; k++) {
                String currWord = queue.poll();

                for (int i = 0; i < currWord.length(); i++) {
                    char[] currArray = currWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currArray[i] = ch;
                        String maybeNext = String.valueOf(currArray);

                        if (available.remove(maybeNext)) {
                            queue.offer(maybeNext);
                            distances.put(maybeNext, layers + 1);
                            graph.computeIfAbsent(maybeNext, key -> new HashSet<>()).add(currWord);
                        } else if (graph.containsKey(maybeNext) && distances.get(currWord) < distances.get(maybeNext)) {
                            graph.get(maybeNext).add(currWord);
                        }
                    }
                }
            }
        }

        if (distances.containsKey(endWord)) {
            findPaths(endWord, new LinkedList<>(), 1, distances.get(endWord), beginWord, graph, distances, paths);
        }
        return paths;
    }

    private void findPaths(String curr, Deque<String> path, int currLen, int len, String finish, Map<String, Set<String>> graph, Map<String, Integer> dists, List<List<String>> paths) {
        path.push(curr);
        if (curr.equals(finish) && currLen == len) {
            paths.add(new ArrayList<>(path));
        } else {
            if (graph.containsKey(curr)) {
                Set<String> children = graph.get(curr);
                for (String child : children) {
                    findPaths(child, path, currLen + 1, len, finish, graph, dists, paths);
                }
            }
        }
        path.pop();
    }

    public static void main(String[] args) {
        WordLadderII instance = new WordLadderII();
        Util.show2dList(instance.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        Util.show2dList(instance.findLadders("red", "tax", List.of("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));
    }
}
