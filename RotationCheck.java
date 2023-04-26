/**
 * Problem from LeetCode
 * https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
 * 
 * Given two n x n binary matrices mat and target, return true if it is possible
 * to make mat equal to target
 * by rotating mat in 90-degree increments, or false otherwise.
 */
public class RotationCheck {

    public boolean findRotation(int[][] mat, int[][] target) {
        // check if the matrix is equal to the target, then
        if (equal(mat, target))
            return true;

        rotate(mat);

        if (equal(mat, target))
            return true;

        rotate(mat);

        if (equal(mat, target))
            return true;

        rotate(mat);

        if (equal(mat, target))
            return true;

        return false;
    }

    // this method checks if two matrices are equal
    // Pre : the matrices are square and of the same size
    public boolean equal(int[][] mat, int[][] target) {
        for (int r = 0; r < mat.length; r++)
            for (int c = 0; c < mat.length; c++)
                if (mat[r][c] != target[r][c])
                    return false;

        return true;

    }

    public void rotate(int[][] matrix) {
        // 0,1 -> 1,2 -> 2,1 -> 1,0
        // 0,0 -> 0, n-1 -> n-1, n-1 -> n-1,0 -> 0,0
        // 0,1 -> 1, n-1 -> n-1, n-2 -> n-2, 0 -> 0,1
        // 1,0 -> 0, n-2 -> n-2, n-1 -> n-1, 1 -> 1,0
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int temp4 = 0;
        // 1,2 -> 0; 3,4->1; 5,6 ->2; 7,8-> 3;
        int n = matrix.length;
        // our goal is to process the top left of the matrix
        // howeffver, we have to provide a double rotation
        // so the inner loop will go
        int outer = n / 2;
        if (n % 2 == 0)
            outer = outer - 1;

        int inner = outer;
        if (n % 2 == 1)
            inner = inner - 1;

        for (int r = 0; r <= outer; r++)
            for (int c = 0; c <= inner; c++) {
                // technically don't need this many temps
                // as we could reuse the matrix elements
                temp1 = matrix[r][c];
                temp2 = matrix[c][n - 1 - r];
                temp3 = matrix[n - 1 - r][n - 1 - c];
                temp4 = matrix[n - 1 - c][r];

                matrix[r][c] = temp4;
                matrix[c][n - 1 - r] = temp1;
                matrix[n - 1 - r][n - 1 - c] = temp2;
                matrix[n - 1 - c][r] = temp3;
            }
    }

    public static void main(String[] args) {
        int[][] matrix = { {0,0,0},{0,1,0},{1,1,1} };
        int[][] target = { {1,1,1},{0,1,0},{0,0,0} };
        // int[][] image = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        
        System.out.println(new RotationCheck().findRotation(matrix, target));

    }
}
