package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> parts = new ArrayList<>();
        doPartition(0, new LinkedList<>(), parts, s);
        return parts;
    }

    public void doPartition(int i, Deque<String> deque, List<List<String>> result, String s) {
        if (i == s.length()) result.add(new ArrayList<>(deque));
        else {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    deque.offerLast(s.substring(i, j + 1));
                    doPartition(j + 1, deque, result, s);
                    deque.pollLast();
                }
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return j < i;
    }

    public static void main(String[] args) {
        PalindromePartitioning instance = new PalindromePartitioning();
        Util.show2dList(instance.partition("aab"));
    }
}
