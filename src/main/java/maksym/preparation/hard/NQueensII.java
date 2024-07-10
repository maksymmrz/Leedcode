package maksym.preparation.hard;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class NQueensII {

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        AtomicInteger counter = new AtomicInteger(0);
        backtrack(board, n, 0, counter);
        return counter.get();
    }

    public void backtrack(char[][] board, int left, int i, AtomicInteger count) {
        if (left == 0) {
            count.incrementAndGet();
        } else {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.' && isValid(board, i, j)) {
                    board[i][j] = 'Q';
                    backtrack(board, left - 1, i + 1, count);
                    board[i][j] = '.';
                }
            }
        }
    }

    public boolean isValid(char[][] board, int i, int j) {
        final int n = board.length;
        for (int x = 0; x < n; x++) {
            if (x != i && board[x][j] == 'Q' || x != j && board[i][x] == 'Q') {
                return false;
            }
        }
        int x = i + 1;
        int y = j + 1;
        while (x < n && y < n) {
            if (board[x][y] == 'Q') {
                return false;
            }
            x++;
            y++;
        }
        x = i - 1;
        y = j - 1;
        while (x >= 0 & y >= 0) {
            if (board[x][y] == 'Q') {
                return false;
            }
            x--;
            y--;
        }
        x = i + 1;
        y = j - 1;
        while (x < n && y >= 0) {
            if (board[x][y] == 'Q') {
                return false;
            }
            x++;
            y--;
        }
        x = i - 1;
        y = j + 1;
        while (x >= 0 && y < n) {
            if (board[x][y] == 'Q') {
                return false;
            }
            x--;
            y++;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueensII instance = new NQueensII();

        char[][] board = new char[][]{
                {'.', '.', '.', '.'},
                {'.', '.', '.', '.'},
                {'.', 'Q', '.', '.'},
                {'.', '.', '.', '.'}
        };

        System.out.println(instance.isValid(board, 2, 1));
        System.out.println(instance.totalNQueens(4));
    }
}
