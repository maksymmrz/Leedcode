package maksym.preparation.medium;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        final int step = 2 * (numRows - 1);

        for (int row = 0; row < numRows; row++) {
            for (int i = row; i < s.length(); i += step) {
                builder.append(s.charAt(i));

                if (row != 0 && row != numRows - 1) {
                    int middle = i + 2 * (numRows - row - 1);
                    if (middle < s.length()) {
                        builder.append(s.charAt(middle));
                    }
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("PAYPALISHIRING", 4));
    }
}
