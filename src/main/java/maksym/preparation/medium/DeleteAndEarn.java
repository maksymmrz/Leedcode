package maksym.preparation.medium;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        for (int num : nums) sums.put(num, sums.getOrDefault(num, 0) + num);
        List<Integer> keys = sums.keySet().stream().sorted().collect(Collectors.toList());

        int first = 0;
        int second = 0;
        int prevKey = -1000000;

        for (Integer key : keys) {
            int sum = sums.get(key);

            int curr = Math.abs(prevKey - key) <= 1 ? Math.max(second + sum, first) : Math.max(first, second) + sum;

            second = first;
            first = curr;
            prevKey = key;
        }
        return Math.max(first, second);
    }


    public static void main(String[] args) {
        DeleteAndEarn o = new DeleteAndEarn();
        System.out.println(o.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(o.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
