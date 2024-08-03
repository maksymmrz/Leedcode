package maksym.preparation.medium;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts[ch]++;
        }
        Deque<Character> deque = new LinkedList<>();
        boolean[] included = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!included[ch]) {
                while (!deque.isEmpty() && deque.peek() > ch && counts[deque.peek()] > 1) {
                    char exclude = deque.pop();
                    included[exclude] = false;
                    counts[exclude]--;
                }
                deque.push(ch);
                included[ch] = true;
            } else counts[ch]--;
        }

        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) builder.append(deque.pollLast());

        return builder.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters instance = new RemoveDuplicateLetters();
        System.out.println(instance.removeDuplicateLetters("abacb"));
        System.out.println(instance.removeDuplicateLetters("cdadabcc"));
        System.out.println(instance.removeDuplicateLetters("cbacdcbc"));
    }
}
