package maksym.preparation.medium.uf;

import java.util.HashSet;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        final int N = isConnected.length;

        var uf = new UF(N);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        var set = new HashSet<Integer>();

        for (int i = 0; i < N; i++) {
            set.add(uf.find(i));
        }

        return set.size();
    }

    private static class UF {
        private final int[] arr;
        private final int[] rank;

        public UF(int n) {
            this.arr = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                this.arr[i] = i;
            }
        }

        public int find(int i) {
            if (arr[i] != i) {
                arr[i] = find(arr[i]);
            }

            return arr[i];
        }

        public void union(int i, int j) {
            int x = find(i);
            int y = find(j);

            if (x != y) {
                if (rank[x] < rank[y]) {
                    arr[x] = y;
                } else if (rank[y] < rank[x]) {
                    arr[y] = x;
                } else {
                    arr[x] = y;
                    rank[y]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        var o = new NumberOfProvinces();

        var m = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(o.findCircleNum(m));
    }
}
