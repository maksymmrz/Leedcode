package maksym.preparation.medium.string;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        final int n = s.length();

        int leftDelta = 0;
        int rightDelta = 0;

        for (int i = 0; i < n; i++) {
            char leftCh = s.charAt(i);
            if (leftCh == '(' || leftCh == '*') leftDelta++;
            else leftDelta--;

            char rightCh = s.charAt(n - 1 - i);
            if (rightCh == ')' || rightCh == '*') rightDelta++;
            else rightDelta--;

            if (leftDelta < 0 || rightDelta < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParenthesisString o = new ValidParenthesisString();
        System.out.println(o.checkValidString("(**))(*()"));
    }
}
