package maksym.preparation.medium;

public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder current = new StringBuilder("1");
        StringBuilder next = new StringBuilder();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < current.length();) {
                int k = j + 1;
                while (k < current.length() && current.charAt(k) == current.charAt(j)) k++;
                next.append(k - j).append(current.charAt(j));
                j = k;
            }
            StringBuilder tmp = current;
            current = next;
            next = tmp;
            next.setLength(0);
        }
        return current.toString();
    }

    public static void main(String[] args) {
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(4));
    }
}
