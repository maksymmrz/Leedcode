package maksym.preparation.medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteAndGetRandom {
    private ArrayList<Integer> list = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private Random rand = new Random(System.currentTimeMillis());

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);

            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            var idx = map.remove(val);
            var last = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            if (last != val) {
                list.set(idx, last);
                map.put(last, idx);
            }

            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        var idx = rand.nextInt(list.size());
        return list.get(idx);
    }

    public static void main(String[] args) {
        var o = new InsertDeleteAndGetRandom();

        for (int i = 0; i < 100; i++) {
            o.insert(i);
        }
        int[] fr = new int[100];

        for (int i = 0; i < 100000; i++) {
            fr[o.getRandom()]++;
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + fr[i]);
        }
    }
}
