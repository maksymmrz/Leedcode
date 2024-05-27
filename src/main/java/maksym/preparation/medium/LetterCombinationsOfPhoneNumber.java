package maksym.preparation.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    private final Map<Character, List<Character>> map =
            Map.of(
                    '2', List.of('a', 'b', 'c'),
                    '3', List.of('d', 'e', 'f'),
                    '4', List.of('g', 'h', 'i'),
                    '5', List.of('j', 'k', 'l'),
                    '6', List.of('m', 'n', 'o'),
                    '7', List.of('p', 'q', 'r', 's'),
                    '8', List.of('t', 'u', 'v'),
                    '9', List.of('w', 'x', 'y', 'z')
            );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (!digits.isEmpty()) {
            backtrack(digits, 0, new StringBuilder(), result);
        }
        return result;
    }

    public void backtrack(String digits, int idx, StringBuilder builder, List<String> res) {
        if (idx < digits.length()) {
            List<Character> prefixes = map.get(digits.charAt(idx));

            for (Character prefix : prefixes) {
                builder.append(prefix);
                backtrack(digits, idx + 1, builder, res);
                builder.setLength(builder.length() - 1);
            }
        } else {
            res.add(builder.toString());
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber instance = new LetterCombinationsOfPhoneNumber();
        System.out.println(instance.letterCombinations("23"));
    }
}
