package maksym.preparation.medium.swindow;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        int[] emptyArr = new int[26];
        Arrays.fill(emptyArr, 0);

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']--;
        }

        int i = 0;

        for (int j = 0; j < s2.length(); j++) {
            while (j - i == s1.length()) {
                counts[s2.charAt(i) - 'a']--;
                i++;
            }

            counts[s2.charAt(j) - 'a']++;

            if (Arrays.compare(counts, emptyArr) == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        var o = new PermutationInString();
        System.out.println(o.checkInclusion("ab", "eidbaooo"));
        System.out.println(o.checkInclusion("ab", "eidboaoo"));
    }
}
