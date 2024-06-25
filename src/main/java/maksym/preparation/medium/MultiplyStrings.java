package maksym.preparation.medium;

import java.util.Arrays;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        final int len = num1.length() + num2.length();
        int[] arr = new int[len];
        Arrays.fill(arr, 0);

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int idx = len - (i + j) - 2;
                int first = num1.charAt(i) - '0';
                int second = num2.charAt(j) - '0';
                arr[idx] += first * second;
            }
        }

        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] += left;
            left = arr[i] / 10;
            arr[i] %= 10;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (builder.length() != 0 || arr[i] != 0 || i == 0) {
                char ch = (char) (arr[i] + '0');
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings instance = new MultiplyStrings();
        System.out.println(instance.multiply("123", "5671").equals("697533"));
        System.out.println(instance.multiply("2", "3"));
        System.out.println(instance.multiply("9", "9"));
        System.out.println(instance.multiply("12", "0"));
    }
}
