package maksym.preparation;

public class Integer2Roman {
    public String intToRoman(int num) {
        int curr = num;
        StringBuilder builder = new StringBuilder();
        while (curr > 0) {
            if (curr - 1000 >= 0) {
                builder.append('M');
                curr -= 1000;
            } else if (curr - 900 >= 0) {
                builder.append("CM");
                curr -= 900;
            } else if (curr - 500 >= 0) {
                builder.append('D');
                curr -= 500;
            } else if (curr - 400 >= 0) {
                builder.append("CD");
                curr -= 400;
            } else if (curr - 100 >= 0) {
                builder.append('C');
                curr -= 100;
            } else if (curr - 90 >= 0) {
                builder.append("XC");
                curr -= 90;
            } else if (curr - 50 >= 0) {
                builder.append('L');
                curr -= 50;
            } else if (curr - 40 >= 0) {
                builder.append("XL");
                curr -= 40;
            } else if (curr - 10 >= 0) {
                builder.append('X');
                curr -= 10;
            } else if (curr == 9) {
                builder.append("IX");
                curr -= 9;
            } else if (curr - 5 >= 0) {
                builder.append('V');
                curr -= 5;
            } else if (curr == 4) {
                builder.append("IV");
                curr -= 4;
            } else {
                builder.append('I');
                curr -= 1;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Integer2Roman().intToRoman(1994));
    }
}
