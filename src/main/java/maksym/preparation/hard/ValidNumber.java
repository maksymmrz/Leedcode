package maksym.preparation.hard;

import java.util.Map;
import java.util.Set;

public class ValidNumber {
    public boolean isNumber(String s) {
        Set<String> finish = Set.of("Q3", "Q5", "Q6", "Q9");
        Map<String, Map<String, String>> transitions = Map.of(
                "Q1", Map.of(
                        "digit", "Q3",
                        "sign", "Q2",
                        "dot", "Q4"
                ),
                "Q2", Map.of(
                        "dot", "Q4",
                        "digit", "Q3"
                ),
                "Q3", Map.of(
                        "digit", "Q3",
                        "dot", "Q6",
                        "exp", "Q7"
                ),
                "Q4", Map.of("digit", "Q5"),
                "Q5", Map.of(
                        "exp", "Q7",
                        "digit", "Q5"
                ),
                "Q6", Map.of(
                        "exp", "Q7",
                        "digit", "Q5"
                ),
                "Q7", Map.of("sign", "Q8", "digit", "Q9"),
                "Q8", Map.of("digit", "Q9"),
                "Q9", Map.of("digit", "Q9")
        );

        String state = "Q1";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String transition = chType(ch);
            if (transition == null) {
                return false;
            }
            String next = transitions.get(state).get(transition);
            if (next == null) {
                return false;
            }
            state = next;
        }
        return finish.contains(state);
    }

    public String chType(char ch) {
        if (Character.isDigit(ch)) return "digit";
        else if (ch == '.') return "dot";
        else if (ch == '-' || ch == '+') return "sign";
        else if (ch == 'e' || ch == 'E') return "exp";
        else return null;
    }

    public static void main(String[] args) {
        ValidNumber instance = new ValidNumber();
        System.out.println(instance.isNumber("-1.9E+-0"));
        System.out.println(instance.isNumber("-90E3"));
        System.out.println(instance.isNumber("-123.456e789"));
        System.out.println(instance.isNumber("-.456e789"));
        System.out.println(instance.isNumber("+123.e789"));
        System.out.println(instance.isNumber("+123.e+789"));
    }
}
