package maksym.preparation.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        restore(s, -1, -1, -1, 3, results);
        return results;
    }

    public void restore(String s, int i, int j, int k, int rem, List<String> results) {
        if (rem == 0) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, j);
            String s3 = s.substring(j, k);
            String s4 = s.substring(k);
            if (isValid(s1, s2, s3, s4)) {
                String ip = String.format("%s.%s.%s.%s", s1, s2, s3, s4);
                results.add(ip);
            }
        } else {
            int from = 0;
            if (rem == 2) from = i;
            else if (rem == 1) from = j;

            for (int idx = from + 1; idx <= s.length() - rem; idx++) {
                if (rem == 3) restore(s, idx, j, k, 2, results);
                if (rem == 2) restore(s, i, idx, k, 1, results);
                if (rem == 1) restore(s, i, j, idx, 0, results);
            }
        }
    }

    public boolean isValid(String s1, String s2, String s3, String s4) {
        return
                isByteValue(s1)
                        && isByteValue(s2)
                        && isByteValue(s3)
                        && isByteValue(s4);
    }

    public boolean isByteValue(String s) {
        if (s.startsWith("0") && s.length() > 1) return false;
        else return s.length() < 4 && Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args) {
        RestoreIPAddresses instance = new RestoreIPAddresses();
        System.out.println(instance.restoreIpAddresses("0000"));
        System.out.println(instance.restoreIpAddresses("1231231231234"));
    }
}
