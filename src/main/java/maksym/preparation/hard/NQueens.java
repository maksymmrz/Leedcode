package maksym.preparation.hard;

import maksym.preparation.util.Util;

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, n, 0, result);
        return new ArrayList<>(result);
    }

    public void backtrack(char[][] board, int remain, int idx, List<List<String>> results) {
        if (remain == 0) {
            List<String> result = new LinkedList<>();
            for (char[] row : board) {
                StringBuilder builder = new StringBuilder();
                for (char cell : row) {
                    builder.append(cell);
                }
                result.add(builder.toString());
            }
            results.add(result);
        } else {
            for (int i = 0; i < board.length; i++) {
                if (board[i][idx] == '.') {
                    board[i][idx] = 'Q';
                    if (isValid(board, i, idx)) {
                        backtrack(board, remain - 1, idx + 1, results);
                    }
                    board[i][idx] = '.';
                }
            }
        }
    }

    public boolean isValid(char[][] board, int x, int y) {
        return crossPosition(board, x, y) && diLeft(board, x, y) && diRight(board, x, y);
    }

    public boolean crossPosition(char[][] board, int x, int y) {
        final int N = board.length;

        for (int i = 0; i < N; i++) {
            if (board[i][y] == 'Q' && i != x) {
                return false;
            }
            if (board[x][i] == 'Q' && i != y) {
                return false;
            }
        }
        return true;
    }

    public boolean diLeft(char[][] board, int x, int y) {
        final int N = board.length;

        int i = x - 1;
        int j = y - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = x + 1;
        j = y + 1;
        while (i < N && j < N) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public boolean diRight(char[][] board, int x, int y) {
        final int N = board.length;

        int i = x - 1;
        int j = y + 1;
        while (i >= 0 && j < N) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        i = x + 1;
        j = y - 1;
        while (i < N && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens instance = new NQueens();

        Util.show2dList(instance.solveNQueens(4));
    }
}
