package maksym.preparation.medium;

import maksym.preparation.util.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsOfSpellsPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        final int N = potions.length;

        int[] spellsCopy = Arrays.copyOf(spells, spells.length);
        Map<Integer, Integer> pairs = new HashMap<>();

        Arrays.sort(spellsCopy);
        Arrays.sort(potions);

        int i = N;

        for (int spell : spellsCopy) {
            while (i > 0 && success <= (long) spell * (long) potions[i - 1]) i--;
            pairs.put(spell, N - i);
        }

        int[] result = new int[spells.length];
        for (int j = 0; j < spells.length; j++) {
            int spell = spells[j];
            result[j] = pairs.get(spell);
        }
        return result;
    }

    public static void main(String[] args) {
        PairsOfSpellsPotions o = new PairsOfSpellsPotions();
        Util.show(o.successfulPairs(new int[]{20, 26, 38, 23, 23, 20, 14, 30}, new int[]{24, 1, 7, 26, 19, 17, 7}, 510));
        Util.show(o.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16));
        Util.show(o.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7));
    }
}
