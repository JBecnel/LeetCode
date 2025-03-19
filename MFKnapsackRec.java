public class MFKnapsackRec {
    static int[][] F;
    static int[] Weights;
    static int[] Values;

    public static int MFKnapsack(int i, int j) {
        if (F[i][j] < 0) { // If the value is not already computed
            int value;
            if (j < Weights[i - 1]) { // If the item is too heavy, skip it
                value = MFKnapsack(i - 1, j);
            } else { // Otherwise, take the maximum of including or excluding the item
                value = Math.max(MFKnapsack(i - 1, j),
                        Values[i - 1] + MFKnapsack(i - 1, j - Weights[i - 1]));
            }
            F[i][j] = value;
        }
        return F[i][j];
    }

    public static int knapsack(int n, int W, int[] weights, int[] values) {
        Weights = weights;
        Values = values;
        F = new int[n + 1][W + 1];

        // Initialize F table with -1, except for row 0 and column 0
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    F[i][j] = 0;
                } else {
                    F[i][j] = -1;
                }
            }
        }

        return MFKnapsack(n, W);
    }

    public static void main(String[] args) {
        int[] weights = {2, 1, 3, 2}; // Example weights
        int[] values = {12, 10, 20, 15}; // Example values
        int W = 5; // Knapsack capacity
        int n = weights.length; // Number of items

        System.out.println("Maximum value in Knapsack: " + knapsack(n, W, weights, values));
    }
}
