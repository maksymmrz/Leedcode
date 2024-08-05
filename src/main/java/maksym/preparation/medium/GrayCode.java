package maksym.preparation.medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> seq = new ArrayList<>();
        final int size = 1 << n;
        boolean[] used = new boolean[size << 2];
        int curr = 0;
        while (seq.size() < size) {
            used[curr] = true;
            seq.add(curr);

            for (int i = 0; i < 16; i++) {
                int one = 1 << i;
                if ((curr & one) > 0) {
                    if (!used[(curr ^ one)]) {
                        curr = (curr ^ one);
                        break;
                    }
                } else {
                    if (!used[(curr | one)]) {
                        curr = (curr | one);
                        break;
                    }
                }
            }
        }
        return seq;
    }

    public static void main(String[] args) {
        GrayCode instance = new GrayCode();
        System.out.println(instance.grayCode(3));
    }
}
