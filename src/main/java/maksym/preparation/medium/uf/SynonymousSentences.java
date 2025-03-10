package maksym.preparation.medium.uf;

import java.util.*;
import java.util.stream.Collectors;

public class SynonymousSentences {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        UF uf = new UF();

        for (List<String> pair : synonyms) {
            String s1 = pair.get(0);
            String s2 = pair.get(1);

            uf.union(s1, s2);
        }

        String[] tokens = text.split(" ");

        Map<String, List<String>> tokenToSet =
                uf.unions().stream()
                        .map(ArrayList::new)
                        .peek(Collections::sort)
                        .flatMap(list -> list.stream().map(s -> Map.entry(s, list)))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        List<String> res = new ArrayList<>();

        bt(tokens, 0, tokenToSet, new LinkedList<>(), res);

        return res;
    }

    private void bt(String[] tokens, int i, Map<String, List<String>> tokenToSet, List<String> acc, List<String> res) {
        final int n = tokens.length;

        if (i == n) {
            StringBuilder s = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (j != 0) s.append(' ');
                s.append(acc.get(j));
            }
            res.add(s.toString());
        } else {
            String token = tokens[i];

            List<String> aliases = tokenToSet.get(token);

            if (aliases != null) {
                for (String alias : aliases) {
                    acc.add(alias);
                    bt(tokens, i + 1, tokenToSet, acc, res);
                    acc.remove(i);
                }
            } else {
                acc.add(token);
                bt(tokens, i + 1, tokenToSet, acc, res);
                acc.remove(i);
            }
        }
    }

    private static class UF {
        private final Map<String, String> map = new HashMap<>();
        private final Map<String, Integer> rank = new HashMap<>();

        public String find(String s) {
            String val = map.computeIfAbsent(s, k -> k);

            if (!s.equals(val)) {
                map.put(s, find(map.get(s)));
            }

            return map.get(s);
        }

        public void union(String a, String b) {
            String v1 = find(a);
            String v2 = find(b);

            if (!v1.equals(v2)) {
                int r1 = rank.computeIfAbsent(v1, k -> 0);
                int r2 = rank.computeIfAbsent(v2, k -> 0);

                if (r1 < r2) {
                    map.put(v1, v2);
                } else if (r1 > r2) {
                    map.put(v2, v1);
                } else {
                    rank.put(v1, r1 + 1);
                    map.put(v2, v1);
                }
            }
        }

        public List<Set<String>> unions() {
            Map<String, Set<String>> sets = new HashMap<>();

            for (String s : map.keySet()) {
                String val = find(s);

                sets.computeIfAbsent(val, k -> new HashSet<>()).add(s);
            }

            return new ArrayList<>(sets.values());
        }
    }

    public static void main(String[] args) {
        SynonymousSentences o = new SynonymousSentences();
        List<List<String>> synonyms = List.of(
                List.of("happy", "joy"),
                List.of("sad", "sorrow"),
                List.of("joy", "cheerful")
        );
        String s = "I am happy today but was sad yesterday";

        System.out.println(o.generateSentences(synonyms, s));
    }
}
