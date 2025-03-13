package maksym.preparation.medium.uf;

public class NumberOfOperationsToConnNet {
    public int makeConnected(int n, int[][] connections) {
        UF uf = new UF(n);
        int redundantEdges = 0;

        for (int[] conn : connections) {
            int a = conn[0];
            int b = conn[1];

            if (!uf.union(a, b)) redundantEdges++;
        }

        int unions = uf.unions();

        if (unions - 1 > redundantEdges) return -1;
        else return unions - 1;
    }

    private static class UF {
        final int[] arr;
        final int[] rank;

        public UF(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            rank = new int[n];
        }

        public int find(int n) {
            if (arr[n] != n) {
                arr[n] = find(arr[n]);
            }
            return arr[n];
        }

        public boolean union(int a, int b) {
            int v1 = find(a);
            int v2 = find(b);

            if (v1 != v2) {
                if (rank[v1] < rank[v2]) {
                    arr[v1] = arr[v2];
                } else if (rank[v2] < rank[v1]) {
                    arr[v2] = arr[v1];
                } else {
                    arr[v2] = arr[v1];
                    rank[v1]++;
                }
                return true;
            }
            return false;
        }

        public int unions() {
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == i) count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        NumberOfOperationsToConnNet o = new NumberOfOperationsToConnNet();

        int[][] connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(o.makeConnected(6, connections));
    }
}
