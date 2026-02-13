package maksym.preparation.hard.swindow;

public class KEmptySlots {
    public int kEmptySlots(int[] bulbs, int k) {
        final var N = bulbs.length;
        final var lightDays = new int[N + 1];

        for (int d = 1; d <= N; d++) {
            final var light = bulbs[d - 1];
            lightDays[light] = d;
        }

        var left = 1;
        var right = left + k + 1;
        var ans = Integer.MAX_VALUE;

        while (right <= N) {
            var maxDay = Math.max(lightDays[left], lightDays[right]);

            for (int i = left + 1; i < right; i++) {
                if (lightDays[i] < maxDay) {
                    left = i;
                    break;
                }
            }

            if (right - left - 1 == k) {
                ans = Math.min(Math.max(lightDays[left], lightDays[right]), ans);
                left = right;
            }

            right = left + k + 1;

        }

        return ans < Integer.MAX_VALUE ? ans : -1;
    }

    public static void main(String[] args) {
        var o = new KEmptySlots();
        System.out.println(o.kEmptySlots(new int[]{3, 9, 2, 8, 1, 6, 10, 5, 4, 7}, 1));
        System.out.println(o.kEmptySlots(new int[]{1, 3, 2}, 1));
    }
}
