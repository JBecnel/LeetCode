import java.util.Arrays;
import java.util.Scanner;

public class Union {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        // read in the elements of A
        System.out.println("Enter the number of elements in the first array: ");
        int n = console.nextInt();
        int[] A = new int[n];
        System.out.println("Enter the elements of A:");
        for (int i = 0; i < n; i++)
            A[i] = console.nextInt();

        // read in the elemetns of B
        System.out.println("Enter the number of elements in the second array: ");
        int m = console.nextInt();
        int[] B = new int[m];
        System.out.println("Enter the elements of B:");
        for (int i = 0; i < m; i++)
            B[i] = console.nextInt();

        // find the union and display the resuts
        int[] c = union(A,B);
        System.out.println("The union of A and B is:");
        for (int i =0; i < c.length; i++) 
            System.out.print(c[i] + " ");

        console.close();
    }
    /**
     * Find the union of two arrays represented as sets.
     * @param A - an array representing a set of integers
     * @param B - an array representing a set of integers
     */
    public static int[] union(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int count = countNumInUnion(A, B);
        
        int[] C = new int[count];
        
        int k = 0;
        int n = A.length;
        int m = B.length;
        int i = 0;
        int j = 0;
        
        while (i < n && j < m) {
            if (A[i] < B[j]) {
                C[k] = A[i];
                i = i + 1;
            } else if (B[j] < A[i]) {
                C[k] = B[j];
                j = j + 1;
            } else {
                C[k] = A[i];
                i++;
                j++;                
            }
            k++;     
              
        }

        if (i == n)
            for (int t = j; t < m; t++) {
                C[k] = B[t];
                k++;
            }
        else 
            for (int t = i; t < n; t++) {
                C[k] = A[t];
                k++;
            }
        
        return C;
    }

    /**
     * 
     */
    public static int countNumInUnion(int[] A, int[] B) {
        int i = 0;
        int j= 0;
        int n = A.length;
        int m = B.length;
        int count = 0;
        while (i < n && j < m)  {
            if (A[i] < B[j])
                i = i +1;
            else if (B[j] < A[i]) 
                j = j +1;
            else {
                i++;
                j++;
            }
            count++;
        }

        if (i == n)
            count = count + m-j;
        else
            count = count + n-i;

        return count;
    }
}
