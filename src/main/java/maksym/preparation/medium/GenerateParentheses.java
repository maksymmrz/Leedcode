package maksym.preparation.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, new StringBuilder(), result);
        return result;
    }

    private void dfs(int left, int right, StringBuilder builder, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(builder.toString());
        } else {
            int len = builder.length();

            if (left > 0) {
                dfs(left - 1, right, builder.append('('), result);
                builder.setLength(len);
            }

            if (left < right) {
                dfs(left, right - 1, builder.append(')'), result);
                builder.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses instance = new GenerateParentheses();
        System.out.println(instance.generateParenthesis(3));
    }
}
