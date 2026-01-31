package maksym.preparation.medium.stack;

import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        var stringSt = new LinkedList<StringBuilder>();
        var numberSt = new LinkedList<Integer>();
        var currentString = new StringBuilder();
        var number = 0;

        for (char ch : s.toCharArray()) {
            if (ch <= 'z' && ch >= 'a') {
                currentString.append(ch);
            } else if (ch <= '9' && ch >= '0') {
                number *= 10;
                number += ch - '0';
            } else if (ch == '[') {
                stringSt.push(currentString);
                currentString = new StringBuilder();
                numberSt.push(number);
                number = 0;
            } else {
                var prefix = stringSt.pop();
                var repeat = numberSt.pop();

                for (int i = 0; i < repeat; i++) {
                    prefix.append(currentString);
                }
                currentString = prefix;
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        var o = new DecodeString();
        System.out.println(o.decodeString("3[a2[c]]"));
    }
}
