//https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
    public void solve(char[][] board) {
        // The key is to find the 0's that can't be flipped.
        /*
         * O's won't be flipped O's will be flipped
         * [X O X X X] [X X X X X]
         * [X O O O X] [X O O O X]
         * [X O X X X] [X O X X X]
         * [X X X X X] [X X X X X]
         * 
         * Idea: if there is a path to the a 0 on the boundary then it won't be flipped.
         */

        // So let's start with the boundary and work inward
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') // first row
                searchForConnectedZeros(board, i, 0);

            if (board[i][board[0].length - 1] == 'O') // last row
                searchForConnectedZeros(board, i, board[0].length - 1);
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') // first column
                searchForConnectedZeros(board, 0, j);

            if (board[board.length - 1][j] == 'O') // last column
                searchForConnectedZeros(board, board.length-1, j);
        }

        // flip all the 0's to X inside the region
        // if they are surrounded
        // Note: we do not have to check boundray
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[0].length; c++)
                if (board[r][c] == 'C')  // the connected 0's remain zer0
                    board[r][c] = 'O';
                else if (board[r][c] == 'O') // the nonconnected 0's turn into X's
                    board[r][c] = 'X';
    }

    private void searchForConnectedZeros(char[][] board, int r, int c) {
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
            if (board[r][c] == 'O') {
                board[r][c] = 'C'; // connected to a 0

                // continue searching in all direction
                searchForConnectedZeros(board, r+1, c);
                searchForConnectedZeros(board, r-1, c);
                searchForConnectedZeros(board, r, c-1);
                searchForConnectedZeros(board, r, c+1);
            }

        } // end if in boundary
        
    }

    public static void main(String[] args) {
        char[][] input = { { 'X', 'X', 'X', 'X' }, 
                           { 'X', 'O', 'O', 'X' }, 
                           { 'X', 'X', 'O', 'X' },
                           { 'X', 'O', 'X', 'X' } };
        new SurroundedRegions().solve(input);
        print(input);
        System.out.println();
        char[][] input2 = { { 'X', 'O', 'X', 'X' },
                { 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X' } };
        new SurroundedRegions().solve(input2);
        print(input2);
        char[][] input3 = { { 'O', 'X', 'X', 'O', 'X' },
                { 'X', 'X', 'X', 'X', 'O' },
                { 'X', 'X', 'X', 'O', 'X' },
                { 'O', 'X', 'O', 'O', 'O' },
                { 'X', 'X', 'O', 'X', 'O' } };
        System.out.println();
        new SurroundedRegions().solve(input3);
        print(input3);
    }

    private static void print(char[][] input3) {
        System.out.println();
        for (int i = 0; i < input3.length; i++) {
            for (int j = 0; j < input3[0].length; j++)
                System.out.print(input3[i][j] + ", ");
            System.out.println();
        }
    }

}
