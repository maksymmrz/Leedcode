package maksym.preparation.medium;

public class EqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] links = new int[26];
        for (int i = 0; i < 26; i++) {
            links[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';

                union(links, x, y);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';

                int xValue = find(links, x);
                int yValue = find(links, y);

                if (xValue == yValue) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int[] arr, int x, int y) {
        int xValue = find(arr, x);
        int yValue = find(arr, y);

        if (xValue != yValue) {
            arr[xValue] = yValue;
        }
    }

    private int find(int[] arr, int target) {
        if (arr[target] != target) {
            int referenceValue = find(arr, arr[target]);
            arr[target] = referenceValue;
        }
        return arr[target];
    }

    public static void main(String[] args) {
        EqualityEquations o = new EqualityEquations();
        System.out.println(o.equationsPossible(new String[]{"b==a","a==b", "c==b"}));
        System.out.println(o.equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"}));
    }
}
