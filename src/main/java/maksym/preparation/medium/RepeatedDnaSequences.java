package maksym.preparation.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> encode = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);
        Map<Integer, Character> decode = Map.of(0, 'A', 1, 'C', 2, 'G', 3, 'T');

        Map<Integer, Integer> count = new HashMap<>();

        int encoded = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            encoded = encoded << 2;
            encoded &= 0B11111111111111111111;
            encoded |= encode.get(s.charAt(j));

            if (j - i == 9) {
                count.put(encoded, 1 + count.getOrDefault(encoded, 0));
                i++;
            }
        }
        List<String> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                int value = entry.getKey();
                StringBuilder builder = new StringBuilder();

                for (int l = 0; l < 10; l++) {
                    char decoded = decode.get(value & 0B11);
                    builder.append(decoded);
                    value = value >> 2;
                }
                result.add(builder.reverse().toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatedDnaSequences o = new RepeatedDnaSequences();
        System.out.println(o.findRepeatedDnaSequences("GAGAGAGAGAGA"));
        System.out.println(o.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
