import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bucees {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("land.dat");
        Scanner file = new Scanner(inputFile);

        // get the size of the table
        int rows = file.nextInt();
        int cols = file.nextInt();

        // read in the table
        int[][] plots = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                plots[i][j] = file.nextInt();

        // find the max side and display the results
        int maxSide = findMaxSide(plots);
        System.out.println("The maximum square area takes up " + maxSide * maxSide + " plots.");

        file.close(); // close the file
    }

    public static int findMaxSide(int[][] plots) {
        int rows = plots.length;
        int cols = plots[0].length;

        int max = 0;
        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                if (plots[i][j] == 1) {
                    plots[i][j] = Math.min(Math.min(plots[i - 1][j], plots[i - 1][j - 1]), plots[i][j - 1]) + 1;
                }
                if (plots[i][j] > max) {
                    max = plots[i][j];
                }
            } // end for

        return max;
    }
}