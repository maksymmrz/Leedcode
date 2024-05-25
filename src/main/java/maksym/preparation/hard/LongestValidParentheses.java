package maksym.preparation.hard;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        int first = 0;
        int second = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') first++;
            else second++;

            if (first == second) {
                max = Math.max(first + second, max);
            } else if (second > first) {
                first = 0;
                second = 0;
            }
        }
        first = 0;
        second = 0;
        for (int i = s.length() - 1; i >= 1; i--) {
            if (s.charAt(i) == ')') second++;
            else first++;
            if (first == second)
                max = Math.max(first + second, max);
            else if (first > second) {
                first = 0;
                second = 0;
            }
        }

        return max;
    }


    public static void main(String[] args) {
        String s1 = "()()()()))(())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s1));

        String s2 = ")(((((((((((((()))";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s2));

        String s3 = "((()))(((((())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s3));
    }
}