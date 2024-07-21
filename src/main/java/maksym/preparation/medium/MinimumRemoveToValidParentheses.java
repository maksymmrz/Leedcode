package maksym.preparation.medium;

public class MinimumRemoveToValidParentheses {

    public String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder();
        int delta = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') delta++;
            else if (ch == ')') delta--;

            if (delta == 0) {
                builder.append(s, start, i + 1);
                start = i + 1;
            } else if (delta < 0) {
                start = i + 1;
                delta = 0;
            }
        }
        int threshold = s.length() - 1;
        while (delta > 0) {
            if (s.charAt(threshold--) == '(') {
                delta--;
            }
        }
        for (int i = start; i < s.length(); i++) {
            if (i <= threshold || s.charAt(i) != '(')
                builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        boolean[] invalid = new boolean[s.length()];
        int delta = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') delta++;
            else if (ch == ')') {
                if (delta == 0) {
                    invalid[i] = true;
                } else delta--;
            }
        }

        delta = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ')') delta++;
            else if (ch == '(') {
                if (delta == 0) {
                    invalid[i] = true;
                } else delta--;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalid[i]) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MinimumRemoveToValidParentheses instance = new MinimumRemoveToValidParentheses();

        System.out.println(instance.minRemoveToMakeValid2("a)b(c)d"));
        System.out.println(instance.minRemoveToMakeValid2("lee(t(c)o)de)"));
        System.out.println(instance.minRemoveToMakeValid2("a(b(c(d)e)f"));
        System.out.println(instance.minRemoveToMakeValid2("())()((("));
        System.out.println();
        System.out.println(instance.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(instance.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(instance.minRemoveToMakeValid("a(b(c(d)e)f"));
        System.out.println(instance.minRemoveToMakeValid("())()((("));
    }
}
