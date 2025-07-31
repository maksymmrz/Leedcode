package maksym.preparation.medium.swindow;

import java.util.*;

public class FindAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        for (char ch : p.toCharArray()) {
            count[toInt(ch)]--;
        }
        List<Integer> res = new ArrayList<>();

        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            count[toInt(s.charAt(j))]++;

            if (j - i == p.length()) {
                count[toInt(s.charAt(i))]--;
                i++;
            }

            if (j - i + 1 == p.length() && isAllZero(count)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isAllZero(int[] arr) {
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private int toInt(char ch) {
        return ch - 'a';
    }

    public static void main(String[] args) {
        FindAnagramsInString o = new FindAnagramsInString();
        System.out.println(o.findAnagrams("cabbaaa", "aba"));
        System.out.println(o.findAnagrams("cbaebabacd", "abc"));
    }
}
