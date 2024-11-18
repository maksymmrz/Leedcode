package maksym.preparation.medium.bsearch;

public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int total = 0;
        int minLoad = 0;

        for (int w : weights) {
            total += w;
            minLoad = Math.max(w, minLoad);
        }
        int l = minLoad;
        int r = total;

        while (l < r) {
            int c = (l + r) / 2;
            if (pass(weights, days, c)) r = c;
            else l = c + 1;
        }
        return l;
    }

    private boolean pass(int[] weights, int days, int capacity) {
        int curr = 0;

        for (int w : weights) {
            if (curr + w <= capacity) {
                curr += w;
            } else {
                days--;
                curr = w;
            }
        }
        return days > 0;
    }

    public static void main(String[] args) {
        CapacityToShipPackages o = new CapacityToShipPackages();
        System.out.println(o.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        System.out.println(o.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println(o.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }
}
