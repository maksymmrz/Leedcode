package maksym.preparation.medium;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentDuplicatesStringII {
    public String removeDuplicates(String s, int k) {
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = builder.length();

            if (len > 0 && builder.charAt(len - 1) == ch) {
                int count = stack.pop();
                stack.push(count + 1);
            } else {
                stack.push(1);
            }
            builder.append(ch);

            if (!stack.isEmpty() && stack.peek() == k) {
                stack.pop();
                builder.setLength(builder.length() - k);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        RemoveAdjacentDuplicatesStringII o = new RemoveAdjacentDuplicatesStringII();
        System.out.println(o.removeDuplicates("deeedbbcccbdaa", 3));
    }
}
