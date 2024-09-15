package maksym.preparation.medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        final int n = gas.length;
        int tank = 0;
        int succed = 0;
        int idx = succed;

        while (idx < 2 * n) {
            int i = idx % n;

            if (succed == n) {
                return i;
            } else {
                tank += gas[i] - cost[i];
                if (tank < 0) {
                    succed = 0;
                    tank = 0;
                } else {
                    succed++;
                }
                idx++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation instance = new GasStation();
        System.out.println(instance.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
