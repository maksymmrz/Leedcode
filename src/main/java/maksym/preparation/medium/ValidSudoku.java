package maksym.preparation.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> used = new HashSet<>(9*10);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (Character.isDigit(ch) && !used.add(ch)) {
                    return false;
                }
            }
            used.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                if (Character.isDigit(ch) && !used.add(ch)) {
                    return false;
                }
            }
            used.clear();
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        char ch = board[x][y];
                        if (Character.isDigit(ch) && !used.add(ch)) {
                            return false;
                        }
                    }
                }
                used.clear();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku instance = new ValidSudoku();
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(instance.isValidSudoku(board));
    }
}
