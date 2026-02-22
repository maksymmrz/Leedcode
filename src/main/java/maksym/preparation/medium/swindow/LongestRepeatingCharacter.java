package maksym.preparation.medium.swindow;

public class LongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxLen = 0;
        int i = 0;
        int maxFreq = 0;

        for (int j = 0; j < s.length(); j++) {
            int pos = s.charAt(j) - 'A';
            counts[pos]++;

            maxFreq = Math.max(counts[pos], maxFreq);

            if (maxFreq + k < j - i + 1) {
                counts[s.charAt(i) - 'A']--;
                i++;
            }

            maxLen = Math.max(j - i + 1, maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacter o = new LongestRepeatingCharacter();
        System.out.println(o.characterReplacement("ABAA", 0));
    }
}
