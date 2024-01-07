package maksym.preparation;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        final int cycle = numRows * 2 - 2;
        StringBuilder builder = new StringBuilder(s.length());

        for (int row = 0; row < numRows; ++row) {
            for (int step = row; step < s.length(); step += cycle) {
                builder.append(s.charAt(step));
                int mid = step + cycle - 2 * row;
                if (row != 0 && row != numRows - 1 && mid < s.length()) {
                    builder.append(s.charAt(mid));
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));
    }
}
