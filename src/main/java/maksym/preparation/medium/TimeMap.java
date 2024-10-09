package maksym.preparation.medium;

import java.util.*;

public class TimeMap {
    final private Map<String, List<Data>> map;

    protected static class Data {
        public String value;
        public int timestamp;
        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    public TimeMap() {
       map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Data> arr = map.get(key);
        if (arr != null) {
            int l = 0;
            int r = arr.size() - 1;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (arr.get(m).timestamp > timestamp) r = m - 1;
                else l = m;
            }
            if (arr.get(l).timestamp <= timestamp) {
                return arr.get(l).value;
            } else {
                return "";
            }
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        TimeMap instance = new TimeMap();
        instance.set("love","high",10);
        instance.set("love","low",20);

        System.out.println(instance.get("love", 5));
        System.out.println(instance.get("love", 10));
        System.out.println(instance.get("love", 15));
        System.out.println(instance.get("love", 20));
        System.out.println(instance.get("love", 25));
    }
}
