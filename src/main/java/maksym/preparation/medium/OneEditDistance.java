package maksym.preparation.medium;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        final int n = Math.min(s.length(), t.length());

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i))
                        || s.substring(i).equals(t.substring(i + 1))
                        || s.substring(i + 1).equals(t.substring(i + 1));

            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    public static void main(String[] args) {
        OneEditDistance instance = new OneEditDistance();
        System.out.println(instance.isOneEditDistance("asaa", "saaa"));
        System.out.println(instance.isOneEditDistance("av", "ae"));
    }
}
