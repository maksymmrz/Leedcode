package maksym.preparation.medium.swindow;

import java.util.*;

public class FindAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) freq[toInt(p, i)]++;

        List<Integer> anagrams = new ArrayList<>();
        int[] count = new int[26];
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            int rightCh = toInt(s, r);
            count[rightCh]++;

            if (r - l + 1 == p.length()) {
                if (Arrays.compare(count, freq) == 0) {
                    anagrams.add(l);
                }

                int leftCh = toInt(s, l);
                count[leftCh]--;

                l++;
            }
            r++;
        }
        return anagrams;
    }

    private int toInt(String s, int i) {
        return s.charAt(i) - 'a';
    }

    public static void main(String[] args) {
        FindAnagramsInString o = new FindAnagramsInString();
        System.out.println(o.findAnagrams("cabbaaa", "aba"));
        System.out.println(o.findAnagrams("cbaebabacd", "abc"));
    }
}
