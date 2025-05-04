package maksym.preparation.medium.twopointers;

public class MovePiecesToObtainString {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) return false;

        final int N = start.length();

        int i = 0;
        int j = 0;

        while (i < N && j < N) {
            while (i < N && start.charAt(i) == '_') i++;
            while (j < N && target.charAt(j) == '_') j++;

            if (i < N && j < N) {

                if (start.charAt(i) != target.charAt(j)) return false;
                else {
                    char ch = start.charAt(i);

                    if (ch == 'L' && i < j) return false;
                    if (ch == 'R' && j < i) return false;
                }

                i++;
                j++;
            }
        }

        while (i < N && start.charAt(i) == '_') i++;
        while (j < N && target.charAt(j) == '_') j++;

        return i == j;
    }

    public static void main(String[] args) {
        MovePiecesToObtainString o = new MovePiecesToObtainString();
        System.out.println(o.canChange("_L__R__R_", "L______RR"));
        System.out.println(o.canChange("R_L_", "R__L"));
        System.out.println(o.canChange("L_R_R", "_L_RR"));
        System.out.println(o.canChange("_L__R__R_", "L______RR"));
    }
}
