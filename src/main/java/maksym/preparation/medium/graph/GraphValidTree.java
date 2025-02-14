package maksym.preparation.medium.graph;

import java.util.stream.IntStream;

public class GraphValidTree {
    private static class UnionF {
        private final int[] conn;
        private final int[] rank;

        public UnionF(int n) {
            this.rank = new int[n];
            this.conn = new int[n];
            for (int i = 0; i < n; i++) {
                this.conn[i] = i;
            }
        }

        public void union(int n1, int n2) {
            int v1 = find(n1);
            int v2 = find(n2);

            if (v1 != v2) {
                if (rank[v1] < rank[v2]) {
                    conn[v1] = v2;
                } else if (rank[v1] > rank[v2]) {
                    conn[v2] = v1;
                } else {
                    conn[v1] = v2;
                    rank[v2]++;
                }
            }
        }

        public int find(int n) {
            if (conn[n] != n)
                conn[n] = find(conn[n]);
            return conn[n];
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionF uf = new UnionF(n);

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];

            int v1 = uf.find(i);
            int v2 = uf.find(j);

            if (v1 == v2) return false;

            uf.union(i, j);
        }
        return IntStream
                .range(0, n)
                .map(uf::find)
                .distinct()
                .count() == 1;
    }

    public static void main(String[] args) {
        GraphValidTree o = new GraphValidTree();
        System.out.println(o.validTree(3, new int[][]{{2, 1}, {1, 0}}));
        System.out.println(o.validTree(4, new int[][]{{0, 1}, {3, 2}}));
        System.out.println(o.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        System.out.println(o.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }
}
