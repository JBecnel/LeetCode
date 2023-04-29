//https://leetcode.com/problems/perfect-squares/description/
/* A dyanamic programming approach seems appropriate
 * where perfectSquare[k] = least number of prefect squares numbers that sum up to k
 * Then perfectSquares[n] = 1+ min {perfectSquare[i] where i = k-1, k-4, k-9, k- 16 ... k - m*m where k-m*m >= 0}
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] perfectSquare = new int[n+1];
        // base cases 1 = 1^2 
        perfectSquare[0] = 0;
        perfectSquare[1] = 1;

        int i, min, current; // i is current index, min are as per formula above
        // current is k - i*i value
        for (int k = 2; k <= n; k++) {
            i = 1;
            min = n; // worst case n = 1 + 1 + .... + 1
            current = k - i*i;
            // this loop finds the min using the formula above
            while (current >= 0) {
                if (perfectSquare[current] < min)
                    min = perfectSquare[current];
                i++;
                current = k - i*i;
            }
            perfectSquare[k] = min +1;
        }
        return perfectSquare[n];
    }
}
