package maksym.preparation.medium;

public class LongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        int maxL = 0;
        int start = 0;
        int maxFrequency = 0;

        for (int end = 0; end < s.length(); end++) {
            int currCh = s.charAt(end) - 'A';
            counter[currCh]++;
            maxFrequency = Math.max(counter[currCh], maxFrequency);

            if (end - start + 1 - maxFrequency > k) {
                counter[s.charAt(start) - 'A']--;
                start++;
            } else {
                maxL = Math.max(end - start + 1, maxL);
            }
        }
        return maxL;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacter o = new LongestRepeatingCharacter();
        System.out.println(o.characterReplacement("ABAA", 0));
    }
}
