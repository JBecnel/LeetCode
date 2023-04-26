/* Dr. Becnel
This program implements Warshall's algorithm.The input is read from a file 
provided at the command line. The output is written to the console.
Sample Run:
> java Warshall matrix.txt
The transitive closure is:
1 1 1 1
1 1 1 1
0 0 0 0
1 1 1 1

Contents of matrix.txt:
4
0 1 0 0
0 0 0 1
0 0 0 0
1 0 1 0
*/

import java.io.*;
import java.util.Scanner;

public class Warshall {
   //=========================MAIN=======================
   /* The method reads from a file given by the first command line argument,
      runs Warshall's algorithm, and displays the results to the console.
      Pre : a file is given as the command line argument. The contents of the file
      contain the number of vertices of the graph and the adjacency matrix.
      Post: the output of Warshall's algorithm (the transitive closure of the graph)
      is displayed to the console.
   */
   public static void main(String[] args) throws IOException {
      File inputFile = new File(args[0]);

      // Create a Scanner object from the File object created above.
      Scanner fileInput = new Scanner(inputFile);

      // Read the first integer value from fileInput object.
      int numElement = fileInput.nextInt();
      boolean[][] graph = new boolean[numElement][numElement];
      
      // read in the adjacency matrix values
      for (int i = 0; i < numElement; i++) 
         for (int j = 0; j < numElement; j++)
            graph[i][j] = (1 == fileInput.nextInt());
      
      // find the transitive closure
      warshall(graph);
            
      // display the results in terms of 0 and 1
      System.out.println("The transitive closure is:");
      for (int i = 0; i < numElement; i++) {
         for (int j = 0; j < numElement; j++)
            System.out.print((graph[i][j] ? 1 : 0) +" ");
         System.out.println(); // go to next line
      }
   }
   
   /* This method is an implementation of Warshall's algorithm.
   Pre : given a boolean adjacency matrix for a graph
   Post: the adjacency matrix is gradually altered into
   the transitive closure through Warshall's algorithm.
   */
   public static void warshall(boolean[][] graph) {
      int numVertices = graph[0].length;
      for (int k = 0; k < numVertices; k++) 
         for (int i = 0; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
               graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
   }

} // end class