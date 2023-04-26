//import javax.lang.model.util.ElementScanner;

public class MaxRectangleBinary {
    // see file MaxRectangeHistogram.java 
    public static int largestRectangleArea(int[] height) {
        int n = height.length;
        int[][] minRect = new int[n][];
        // minRect[i][j] - holds the minimum height of rect[j], rect[j+1], ...., rect[i]


        // create jagged arrays
        // 0,0
        // 1,0  1,1
        // 2.0, 2,1 22
        //....
        /// with minRect[i][i] holding only the height of rect[i]
        int max = 0; // holds the max rectangle value
        for (int i = 0; i < n; i++) {
            minRect[i] = new int[i+1]; 
            minRect[i][i] = height[i];
            max = Math.max(max, height[i]);
        }
        // at this stage max holds the value of tallest bar 
        // we now consider rectangles made from multiple bars
        // the area of each  is found by base x height were
        // base = # of histogram bars (i-j+1)
        // height is height of the minimum rectangle
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++) {
                minRect[i][j] = Math.min(minRect[i-1][j], height[i]);
                max = Math.max(max, minRect[i][j] * (i-j+1));
            }
        return max;
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length; // number of columns
        int[] height = new int[n];  // holds the height number of 1's in a column at each step

        int m = matrix.length; // number of rows
        // for each row in the matrix, we treat the number of
        // 1's from the base of that row as a histogram and use
        // the method above;
        System.out.println(m + " "+ n);
        int maxRect = 0;
        int currentRect = 0;        
        for (int i= 0; i < m; i++) {  // traverse row by row
            for (int j = 0; j < n; j++) {  // adjust the heights based if there is another 1 in the current row
                if (matrix[i][j] == '1') {
                    height[j] = height[j] + 1;
                    System.out.println(height[j]);
                }
                else
                    height[j] = 0;  // no rectangle

                System.out.print(j + " "+ height[j]+ " ");
            }
            System.out.println();
            // treating the current row as the base
            // find the largest rect in the histogram
            currentRect = largestRectangleArea(height); 
            if (currentRect > maxRect)
                maxRect = currentRect;

        }
        return maxRect;
    }

    // this is a simple method to print a double array of integers
    // to the console
    public static void printTable(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++)
                System.out.print(table[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] m = {
//                { '1', '0', '1', '0', '0' },
  //              { '1', '0', '1', '1', '1' },
    //            { '1', '1', '1', '1', '1' },
      //          { '1', '0', '0', '1', '0' }
       {'1','0'}    
    };
        System.out.println(
        maximalRectangle(m)
        );
    }

}
