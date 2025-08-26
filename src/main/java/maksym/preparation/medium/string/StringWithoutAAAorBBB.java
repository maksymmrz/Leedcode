package maksym.preparation.medium.string;

public class StringWithoutAAAorBBB {
    public String strWithout3a3b(int a, int b) {
        var str = new StringBuilder();
        final int N = a + b;


        for (int i = 0; i < N; i++) {

            if (i > 1) {
                var p1 = str.charAt(i - 1);
                var p2 = str.charAt(i - 2);

                if (p1 == p2) {
                    if (p1 == 'b') {
                        str.append('a');
                        a--;
                    } else {
                        str.append('b');
                        b--;
                    }
                } else {
                    if (a < b) {
                        str.append('b');
                        b--;
                    } else {
                        str.append('a');
                        a--;
                    }
                }
            } else {
                if (a < b) {
                    str.append('b');
                    b--;
                } else {
                    str.append('a');
                    a--;
                }
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        var o = new StringWithoutAAAorBBB();

        System.out.println(o.strWithout3a3b(4, 1));
    }
}
