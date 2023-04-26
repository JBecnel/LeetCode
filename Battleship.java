public class Battleship {
    public int countBattleships(char[][] board) {
        // get grid dimensions and
        // enrusre there is a grid
        int m = board.length;
        if (m == 0)
            return 0;
        int n = board[0].length;

        int count = 0; // count the number of ships

        // traverse the grid from top left to bottom right
        // row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // when encoutner an X
                if (board[i][j] == 'X') {
                    // check to see if it part of a previously known ship
                    // by examining left and above this X
                    if ((i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                        // if not part of another ship increment the counter
                        count++;
                    }  // end if
                } // end if
            } // end for
        }  // end for

        return count;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
        System.out.println(new Battleship().countBattleships(board));
    }
}
