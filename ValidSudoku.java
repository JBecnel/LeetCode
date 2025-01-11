import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
// https://leetcode.com/problems/valid-sudoku/description/
public class ValidSudoku {
    public static void main(String[] args) throws FileNotFoundException {
        char[][] board = readBoard("board.txt");
        System.out.println(new ValidSudoku().isValidSudoku(board));

        board = readBoard("board2.txt");
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

    public static char[][] readBoard(String name) throws FileNotFoundException {
        File file = new File(name);
        Scanner infile = new Scanner(file);
        char[][] board = new char[9][9];
        for (int r = 0; r < 9; r++)
            for (int c = 0; c < 9; c++)
                board[r][c] = infile.next().charAt(0);
        
        return board;
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> check = new HashSet<Character>();
        final int BOARD_SIZE = 9;

        // check all rows
        for (int row = 0; row < BOARD_SIZE; row++) {
            check = new HashSet<Character>();
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] != '.') {
                    if (!check.add(board[row][col]))
                        return false;
                }

            }
        }

        // check all cols
        for (int col = 0; col < BOARD_SIZE; col++) {
            check = new HashSet<Character>();
            for (int row = 0; row < BOARD_SIZE; row++) {
                if (board[row][col] != '.') {
                    if (!check.add(board[row][col]))
                        return false;
                }

            }
        }

        // check all 9 x 9
        for (int offrow = 0; offrow < BOARD_SIZE; offrow = offrow + 3)
            for (int offcol = 0; offcol < BOARD_SIZE; offcol = offcol + 3) {
                check = new HashSet<Character>();
                for (int r = 0; r <= 2; r++)
                    for (int c = 0; c <= 2; c++)
                        if (board[r + offrow][c+offcol] != '.') {
                            if (!check.add(board[r + offrow][c+offcol]))
                                return false;
                    }
            }
        
        return true;
    }
}
