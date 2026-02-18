package maksym.preparation.hard.graph;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        final var N = words.length;
        final var inDegree = new HashMap<Character, Integer>();
        final var relations = new HashMap<Character, Set<Character>>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                var ch = word.charAt(i);
                inDegree.put(ch, 0);
                relations.put(ch, new HashSet<>());
            }
        }

        for (int i = 1; i < N; i++) {
            var prev = words[i - 1];
            var curr = words[i];

            var pos = 0;
            var shortest = Math.min(prev.length(), curr.length());

            while (pos < shortest && prev.charAt(pos) == curr.charAt(pos)) pos++;

            if (pos < shortest) {
                var prevCh = prev.charAt(pos);
                var currCh = curr.charAt(pos);

                var nextChars = relations.computeIfAbsent(prevCh, k -> new HashSet<>());
                if (nextChars.add(currCh)) {
                    inDegree.put(currCh, inDegree.getOrDefault(currCh, 0) + 1);
                }
            } else if (curr.length() < prev.length()) {
                return "";
            }
        }

        var ans = new StringBuilder();
        var q = new LinkedList<Character>();

        for (Character ch : relations.keySet()) {
            if (inDegree.getOrDefault(ch, 0) == 0) {
                q.add(ch);
            }
        }

        while (!q.isEmpty()) {
            var curr = q.poll();
            ans.append(curr);

            var nextChars = relations.getOrDefault(curr, Collections.emptySet());

            for (Character next : nextChars) {
                var count = inDegree.get(next) - 1;
                inDegree.put(next, count);

                if (count == 0) {
                    q.offer(next);
                }
            }
        }

        if (inDegree.size() == ans.length()) {
            return ans.toString();
        }

        return "";
    }

    public static void main(String[] args) {
        var o = new AlienDictionary();
        System.out.println(o.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(o.alienOrder(new String[]{"ac", "ab", "zc", "zb"}));
        System.out.println(o.alienOrder(new String[]{"abc", "ab"}));
    }
}
