package maksym.preparation.medium.string;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int a = 0;
        int b = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                a++;
            } else {
                b = Math.max(1 + a, b + 1);
            }
        }

        return s.length() - Math.max(a, b);
    }

    public static void main(String[] args) {
        var o = new MinimumDeletionsToMakeStringBalanced();
        System.out.println(o.minimumDeletions("aababbab"));
    }
}
