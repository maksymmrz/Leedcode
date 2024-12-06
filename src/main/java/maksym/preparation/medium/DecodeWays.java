package maksym.preparation.medium;


public class DecodeWays {

    public int numDecodings(String s) {
        if (s.isEmpty()) return 1;
        if (s.charAt(0) == '0') return 0;

        int curr = 1;
        int prev = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    int tmp = curr;
                    curr = prev;
                    prev = tmp;
                } else {
                    return 0;
                }
            } else if ((s.charAt(i - 1) == '1') || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                int ways = curr + prev;
                prev = curr;
                curr = ways;
            } else {
                prev = curr;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        DecodeWays instance = new DecodeWays();
        System.out.println(instance.numDecodings("120"));
        System.out.println(instance.numDecodings("1201234"));
    }
}
