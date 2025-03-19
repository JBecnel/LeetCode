
class Knapsack {
			
	static int knapSack(int W, int wt[], int val[], int n)	{
		int i, w;
		int V[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++)		{
			for (w = 0; w <= W; w++)			{
				if (i == 0 || w == 0)
					V[i][w] = 0;
				else if (wt[i - 1] <= w)
					V[i][w]	= Math.max(
									val[i - 1]+ V[i - 1][w - wt[i - 1]],	
									V[i - 1][w]
								);
				else
					V[i][w] = V[i - 1][w];
			}
		}

		return V[n][W];
	}

	
	public static void main(String args[])	{
		int val[] = new int[] { 12,10,20,15 };
		int wt[] = new int[] { 2,1,3,2 };
		int W = 5;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}

