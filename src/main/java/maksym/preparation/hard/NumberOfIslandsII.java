package maksym.preparation.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        boolean[][] g = new boolean[m][n];
        List<Integer> result = new ArrayList<>();
        UF u = new UF(m * n);
        int islands = 0;

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] p : positions) {
            int i = p[0];
            int j = p[1];

            if (!g[i][j]) {
                g[i][j] = true;
                islands++;

                Set<Integer> neighbors = new HashSet<>();
                int currID = i * n + j;

                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && g[x][y]) {
                        int islandID = u.find(x * n + y);
                        neighbors.add(islandID);
                    }
                }

                for (Integer neighbor : neighbors) {
                    u.union(neighbor, currID);
                }

                islands -= neighbors.size();
            }
            result.add(islands);
        }
        return result;
    }

    private static class UF {
        private final int[] arr;
        private final int[] rank;

        public UF(int n) {
            this.arr = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) arr[i] = i;
        }

        public int find(int n) {
            if (arr[n] != n) {
                arr[n] = find(arr[n]);
            }
            return arr[n];
        }

        public void union(int n1, int n2) {
            int v1 = find(n1);
            int v2 = find(n2);

            if (v1 != v2) {
                if (rank[v1] < rank[v2]) {
                    arr[v1] = arr[v2];
                } else if (rank[v2] < rank[v1]) {
                    arr[v2] = arr[v1];
                } else {
                    arr[v1] = v2;
                    rank[v2]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslandsII o = new NumberOfIslandsII();
        System.out.println(o.numIslands2(8, 4, new int[][]{{0, 0}, {7, 1}, {6, 1}, {3, 3}, {4, 1}}));
        System.out.println(o.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {1, 2}}));
        System.out.println(o.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}, {1, 1}}));
    }
}
