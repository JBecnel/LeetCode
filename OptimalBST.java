// Dynamic Programming Java code for Optimal Binary Search
// Tree Problem
public class OptimalBST {
	
	/* A Dynamic Programming based function that calculates
		minimum cost of a Binary Search Tree. */
	static double optimalSearchTree( double prob[]) {

		/* Create an auxiliary 2D matrix to store results of
		subproblems */
      int n = prob.length-1;
		double cost[][] = new double[n + 2][n + 1];

		/* cost[i][j] = Optimal cost of binary search tree that
		can be formed from keys[i] to keys[j]. cost[0][n-1]
		will store the resultant cost */

		// For a single key, cost is equal to frequency of the key
		for (int i = 1; i <= n; i++) {
         cost[i][i-1]=0;
			cost[i][i] = prob[i];
      }
      cost[n+1][n]=0; 
      
		// Now we need to consider chains of length 2, 3, ... .
		// L is chain length.
		for (int d = 1; d <= n-1; d++) {

			// i is row number in cost[][]
			for (int i = 1; i <= n - d; i++) {

				// Get column number j from row number i and
				// chain length L
				int j = i + d;

            double min = 1000000.0;

				// Try making all keys in interval keys[i..j] as root
				for (int k = i; k <= j; k++) {

					// c = cost when keys[r] becomes root of this subtree
					if (cost[i][k - 1] +  cost[k + 1][j] < min)
                  min = cost[i][k - 1] +  cost[k + 1][j]; 
					
				}
            cost[i][j] = min +  sum(prob, i, j);
            
			}
		}
      
      for (int i = 1; i <= n+1; i++) {
        for (int j = 0; j <= n; j++) 
            System.out.print(cost[i][j] + " ");
        System.out.println();
      }
		return cost[1][n];
	}

	// A utility function to get sum of array elements
	// freq[i] to freq[j]
	static double sum(double freq[], int i, int j) {
		double s = 0;
		for (int k = i; k <= j; k++) {
			s += freq[k];
		}
   
		return s;
	}

	public static void main(String[] args) {
		
		double freq[] = {0, .25, .5, .15, 0.1 };
		
		System.out.println("Cost of Optimal BST is "
				+ optimalSearchTree( freq));
	}

}
