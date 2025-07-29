package maksym.preparation.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int pos = 0;
        int len = strs[0].length();

        for (String str : strs) {
            len = Math.min(len, str.length());
        }

        for (; pos < len; pos++) {
            char ch = strs[0].charAt(pos);
            boolean notSame = false;

            for (var s : strs) {
                if (s.charAt(pos) != ch) {
                    notSame = true;
                    break;
                }
            }

            if (notSame) {
                break;
            }
        }

        return strs[0].substring(0, pos);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
