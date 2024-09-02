package maksym.preparation.medium;

public class SurroundedRegions {
    public void solve(char[][] board) {
        final int m = board.length - 1;
        final int n = board[0].length - 1;

        for (int i = 0; i <= m; i++) {
            if (board[i][0] == 'O') mark(board, i, 0);
            if (board[i][n] == 'O') mark(board, i, n);
        }
        for (int j = 0; j <= n; j++) {
            if (board[0][j] == 'O') mark(board, 0, j);
            if (board[m][j] == 'O') mark(board, m, j);
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

    public void mark(char[][] board, int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'O') {
            board[i][j] = '1';
            mark(board, i - 1, j);
            mark(board, i + 1, j);
            mark(board, i, j - 1);
            mark(board, i, j + 1);
        }
    }

    public static void main(String[] args) {
        SurroundedRegions instance = new SurroundedRegions();
        char[][] matrix = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        instance.solve(matrix);
        for (char[] row : matrix) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
