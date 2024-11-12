package maksym.preparation.medium;

import java.util.stream.IntStream;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = IntStream.of(piles).max().orElse(1);

        int l = 1;
        int r = max;

        while (l < r) {
            int speed = (l + r) / 2;
            if (isValidSpeed(piles, h, speed)) r = speed;
            else l = speed + 1;
        }
        return l;
    }

    public boolean isValidSpeed(int[] piles, int h, int speed) {
        int time = 0;
        int i = 0;
        while (i < piles.length && time < h) {
            time += piles[i] / speed;
            if (piles[i] % speed > 0) time++;
            i++;
        }
        return i == piles.length && time <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas o = new KokoEatingBananas();
        System.out.println(o.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(o.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
    }
}
