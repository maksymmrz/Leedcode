package maksym.preparation.hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justified = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int length = 0;

        for (String word : words) {
            int minWidth = length > 0 ? length + currentLine.size() + word.length() : word.length();

            if (minWidth > maxWidth) {
                int spacesNum = currentLine.size() - 1;
                if (spacesNum == 0) {
                    String line = currentLine.get(0);
                    int fill = maxWidth - line.length();
                    justified.add(line + " ".repeat(fill));
                    currentLine.clear();
                    length = 0;
                } else {
                    String space = " ".repeat((maxWidth - length) / spacesNum);
                    int remainder = (maxWidth - length) % spacesNum;
                    StringBuilder builder = new StringBuilder();

                    for (int j = 0; j < currentLine.size(); j++) {
                        String w = currentLine.get(j);
                        builder.append(w);
                        if (j != currentLine.size() - 1) {
                            builder.append(space);
                            if (remainder > 0) {
                                builder.append(' ');
                                remainder--;
                            }
                        }
                    }
                    justified.add(builder.toString());
                    currentLine.clear();
                    length = 0;
                }
            }
            currentLine.add(word);
            length += word.length();
        }
        String last = String.join(" ", currentLine);
        justified.add(last + " ".repeat(maxWidth - last.length()));

        return justified;
    }

    public static void main(String[] args) {
        TextJustification instance = new TextJustification();
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        System.out.println(instance.fullJustify(words, 16));
    }
}
