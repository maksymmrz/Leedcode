package maksym.preparation.easy;

public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int[] chronology = new int[150];

        for (int[] log : logs) {
            int s = log[0];
            int e = log[1];

            chronology[s - 1950]++;
            chronology[e - 1950]--;
        }

        int ppl = 0;
        int max = 0;
        int year = 0;

        for (int y = 0; y < chronology.length; y++) {
            ppl += chronology[y];

            if (max < ppl) {
                max = ppl;
                year = y;
            }
        }

        return year + 1950;
    }

    public static void main(String[] args) {
        MaximumPopulationYear o = new MaximumPopulationYear();

        int[][] logs = new int[][]{{2008, 2026}, {2004, 2008}, {2034, 2035}, {1999, 2050}, {2049, 2050}, {2011, 2035}, {1966, 2033}, {2044, 2049}};
        System.out.println(o.maximumPopulation(logs));
    }
}
