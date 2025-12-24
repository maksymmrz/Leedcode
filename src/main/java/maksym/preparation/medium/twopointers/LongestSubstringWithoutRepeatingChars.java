package maksym.preparation.medium.twopointers;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        Integer[] charPos = new Integer[128];

        int maxLen = 0;
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);

            Integer pos = charPos[ch];

            if (pos != null && pos >= l) {
                l = pos + 1;
            }

            maxLen = Math.max(r - l + 1, maxLen);

            charPos[ch] = r;

            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("pwwkew"));
    }
}
