package main.java.person.maksym.preparation;

public class String2Integer {

    public int myAtoi(String s) {
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) == ' ') idx++;

        int sign = 1;
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = s.charAt(idx) == '-' ? -1 : 1;
            idx++;
        }

        long result = 0;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';
            result = result * 10 + digit;

            long intermediate = result * sign;
            if (intermediate >= Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
                break;
            } else if (intermediate <= Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
                break;
            }
            idx++;
        }
        return (int)(result * sign);
    }

    public static void main(String[] args) {
        System.out.println(new String2Integer().myAtoi("-3rr"));
    }
}
