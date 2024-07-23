package maksym.preparation.medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = dfs(board, i, j, word, 0, used);
                if (res) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int i, boolean[][] used) {
        if (word.charAt(i) != board[x][y]) {
            return false;
        }
        if (i == word.length() - 1) {
            return true;
        }

        final int m = board.length;
        final int n = board[0].length;
        boolean result = false;
        used[x][y] = true;

        x++;
        if (x < m && !used[x][y]) {
            result = dfs(board, x, y, word, i + 1, used);
        }
        x -= 2;
        if (x >= 0 && !used[x][y] && !result) {
            result = dfs(board, x, y, word, i + 1, used);
        }
        x++;
        y++;
        if (y < n && !used[x][y] && !result) {
            result = dfs(board, x, y, word, i + 1, used);
        }
        y -= 2;
        if (y >= 0 && !used[x][y] && !result) {
            result = dfs(board, x, y, word, i + 1, used);
        }
        y++;
        used[x][y] = false;
        return result;
    }

    public static void main(String[] args) {
        WordSearch instance = new WordSearch();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(instance.exist(board, "ESE"));
    }
}
