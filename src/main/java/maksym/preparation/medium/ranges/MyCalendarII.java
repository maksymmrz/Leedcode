package maksym.preparation.medium.ranges;

import java.util.*;

public class MyCalendarII {

    private final TreeMap<Integer, Integer> ranges = new TreeMap<>();

    public MyCalendarII() {}

    public boolean book(int startTime, int endTime) {
        ranges.put(startTime, 1 + ranges.getOrDefault(startTime, 0));
        ranges.put(endTime, ranges.getOrDefault(endTime, 0) - 1);

        int prefix = 0;

        for (Map.Entry<Integer, Integer> entry : ranges.entrySet()) {
            int diff = entry.getValue();

            prefix += diff;

            if (prefix > 2) {
                ranges.put(startTime, ranges.getOrDefault(startTime, 0) - 1);
                ranges.put(endTime, ranges.getOrDefault(endTime, 0) + 1);

                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII calendar = new MyCalendarII();

        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(50, 60));
        System.out.println(calendar.book(10, 40));
        System.out.println(calendar.book(5, 15));
        System.out.println(calendar.book(5, 10));
        System.out.println(calendar.book(20, 25));
    }
}
