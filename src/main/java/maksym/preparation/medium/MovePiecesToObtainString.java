package maksym.preparation.medium;

public class MovePiecesToObtainString {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;

        final int n = start.length();

        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            if (i == n && j < n || j == n && i < n) return false;

            if (i != n && j != n) {
                if (start.charAt(i) != target.charAt(j)) return false;
                if (start.charAt(i) == 'L' && i < j) return false;
                if (start.charAt(i) == 'R' && j < i) return false;

                i++;
                j++;
            }
        }

        while (i < n && start.charAt(i) == '_') i++;
        while (j < n && target.charAt(j) == '_') j++;

        return i == j;
    }

    public static void main(String[] args) {
        MovePiecesToObtainString o = new MovePiecesToObtainString();
        System.out.println(o.canChange("R_L_", "__LR"));
        System.out.println(o.canChange("L_R_R", "_L_RR"));
        System.out.println(o.canChange("_L__R__R_", "L______RR"));
    }
}
