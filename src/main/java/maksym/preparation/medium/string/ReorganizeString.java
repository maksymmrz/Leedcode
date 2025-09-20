package maksym.preparation.medium.string;

import java.util.Arrays;
import java.util.Comparator;

public class ReorganizeString {
    public String reorganizeString(String s) {
        final int N = s.length();

        final int[][] fr = new int[26][2];

        for (int i = 0; i < 26; i++) {
            fr[i][1] = i;
        }

        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);

            fr[ch - 'a'][0]++;
        }

        Arrays.sort(fr, Comparator.comparingInt(a -> -a[0]));

        if (fr[0][0] > (N + 1) / 2) return "";

        int idx = 0;

        var ans = new int[N];

        for (int i = 0; i < N; i += 2) {
            while (fr[idx][0] == 0) { idx++; }

            ans[i] = fr[idx][1] + 'a';

            fr[idx][0]--;
        }

        for (int i = 1; i < N; i += 2) {
            while (fr[idx][0] == 0) {
                idx++;
            }

            ans[i] = fr[idx][1] + 'a';

            fr[idx][0]--;
        }

        return new String(ans, 0, ans.length);
    }

    public static void main(String[] args) {
        var o = new ReorganizeString();

        System.out.println(o.reorganizeString("aab"));
        System.out.println(o.reorganizeString("aaabc"));
        System.out.println(o.reorganizeString("ogccckcwmbmxtsbmozli"));
        System.out.println(o.reorganizeString("aaaaabbb"));
    }
}
