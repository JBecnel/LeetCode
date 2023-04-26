/**
 * Problem from LeetCode
 * https://leetcode.com/problems/rotate-image/
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
      // 0,1 -> 1,2 -> 2,1 -> 1,0
      // 0,0 -> 0, n-1 -> n-1, n-1 -> n-1,0 -> 0,0
      // 0,1 -> 1, n-1 -> n-1, n-2 -> n-2, 0 ->  0,1
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
      int outer = n /2; 
      if (n % 2 == 0)
        outer = outer -1;
      
      int inner = outer;
      if (n % 2 == 1)
        inner = inner -1;

      for (int r = 0; r <= outer; r++)
        for (int c =0; c <= inner; c++) {
            // technically don't need this many temps
            // as we could reuse the matrix elements
            temp1 = matrix[r][c];
            temp2 = matrix[c][n-1-r];
            temp3 = matrix[n-1-r][n-1-c];
            temp4 = matrix[n-1-c][r];

            matrix[r][c] = temp4;
            matrix[c][n-1-r] = temp1;
            matrix[n-1-r][n-1-c] = temp2;
            matrix[n-1-c][r] = temp3;
        }
    }   
    
    public static void main(String[] args) {
        int[][] image = {{1,2,3}, {4,5,6}, {7,8,9}};
        //int[][] image = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        new RotateImage().rotate(image);
        System.out.println(image.toString());

    }
}
