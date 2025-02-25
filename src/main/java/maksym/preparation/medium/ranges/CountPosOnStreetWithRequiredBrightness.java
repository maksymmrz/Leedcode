package maksym.preparation.medium.ranges;

public class CountPosOnStreetWithRequiredBrightness {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] diff = new int[n];

        for (int[] light : lights) {
            int[] range = range(light, n);
            int s = range[0];
            int e = range[1];

            diff[s]++;
            if (e + 1 < n) diff[e + 1]--;
        }

        int count = 0;
        int prefix = 0;

        for (int i = 0; i < n; i++) {
            prefix += diff[i];
            if (prefix >= requirement[i]) count++;
        }

        return count;
    }

    private int[] range(int[] light, int n) {
        int r = light[1];
        int center = light[0];

        int s = Math.max(center - r, 0);
        int e = Math.min(center + r, n - 1);

        return new int[]{s, e};
    }

    public static void main(String[] args) {
        CountPosOnStreetWithRequiredBrightness o = new CountPosOnStreetWithRequiredBrightness();

        int[][] lights = new int[][]{{0, 1}, {2, 1}, {3, 2}};
        int[] requirement = new int[]{0, 2, 1, 4, 1};

        System.out.println(o.meetRequirement(5, lights, requirement));
    }
}
