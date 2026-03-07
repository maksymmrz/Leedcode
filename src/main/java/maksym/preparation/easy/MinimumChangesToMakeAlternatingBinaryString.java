package maksym.preparation.easy;

public class MinimumChangesToMakeAlternatingBinaryString {
    public int minOperations(String s) {
        var odd = 0;
        var even = 0;

        for (int i = 0; i < s.length(); i++) {
            var curr = s.charAt(i);

            if (i % 2 == 0) {
                if (curr == '1') odd++;
                else even++;
            } else {
                if (curr == '1') even++;
                else odd++;
            }
        }

        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        var o = new MinimumChangesToMakeAlternatingBinaryString();
        System.out.println(o.minOperations("1111"));
    }
}
