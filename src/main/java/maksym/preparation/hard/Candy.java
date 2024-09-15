package maksym.preparation.hard;


import java.util.stream.IntStream;

public class Candy {
    public int candy(int[] ratings) {
        final int n = ratings.length;
        int[] candis = new int[n];

        int i = 0;
        while (i < n) {
            int prev = i > 0 ? ratings[i - 1] : Integer.MAX_VALUE;
            int next = i < n - 1 ? ratings[i + 1] : Integer.MAX_VALUE;

            if (prev >= ratings[i] && ratings[i] <= next) {
                candis[i] = 1;
                i++;
            } else if (prev < ratings[i] && ratings[i] <= next) {
                candis[i] = candis[i - 1] + 1;
                i++;
            } else {
                int j = i;
                while (j < n - 1 && ratings[j] > ratings[j + 1]) j++;
                final int nextIdx = j + 1;
                int count = 1;
                while (i < j) {
                    candis[j] = count;
                    count++;
                    j--;
                }
                if (j - 1 >= 0 && ratings[j - 1] < ratings[j]) {
                    int left = candis[j - 1];
                    int right = j + 1 < n ? candis[j + 1] : 0;
                    candis[j] = Math.max(left, right) + 1;
                } else {
                    candis[j] = count;
                }
                i = nextIdx;
            }
        }
        return IntStream.of(candis).sum();
    }

    public static void main(String[] args) {
        Candy instance = new Candy();
        System.out.println(instance.candy(new int[]{1,0,1}));
        System.out.println(instance.candy(new int[]{1,2,3,4,1}));
    }
}
