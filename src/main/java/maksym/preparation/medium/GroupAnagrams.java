package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String word : strs) {
            char[] chs = word.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            groups.computeIfAbsent(key, k -> new LinkedList<>()).add(word);
        }
        return new LinkedList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams instance = new GroupAnagrams();

        String[] words1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Util.show2dList(instance.groupAnagrams(words1));
    }
}
