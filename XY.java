/* Dr. Becnel
This program takes an array of characters, X and Y only. The program outputs
the number of subarrays that start with Y and end with X.

Sample Run:
Enter the number of elements in the array: 8
Enter 8 X’s or Y’s separated by a space: 
X X Y X Y Y X X

There are 7 substrings that start with Y and end with X. 

 */

// scanner for console input
import java.util.Scanner;

public class XY {
    //===================MAIN====================
    /* This method reads an array of real numbers
    X and Y characters form the console.
     */
    public static void main(String[] args) {
        // read in the number of array elements
        System.out.print("Enter the number of elements in the array: ");
        Scanner console = new Scanner(System.in);
        int numElements = console.nextInt();
    
        // read in the array elements
        System.out.println("Enter " + numElements+ "  Xs or Ys separated by a space");
        char[] c = new char[numElements];
        for (int i = 0; i < numElements; i++)
            c[i] = console.next().charAt(0);
    
        console.close();
        
        // find the number of sub arrays that start with a Y and end with a X
        int numSubStrings = countSubstrings(c);
        System.out.println();
        System.out.println("There are " + numSubStrings + " that start with a Y and end with a X.");
    }

    // coutSubstrinags
    public static int countSubstrings(String str) {
        return  countSubstrings( str.toCharArray());
    }

    //-------------------countSubstrings----------------------
    /* This method takes an character array and counts the number of
    subarrays that start with a Y and ends with a X.
    Pre : given an array of X and Y characters
    Post: the number of subarrays that start with a Y and end with an X are counted
    */
    public static int countSubstrings(char[] c) {
        int count = 0; // used to track number of substrings

        // outer loop - find strings that start with Y
        for (int i = 0; i < c.length-1; i++) 
	        if (c[i] == 'Y')   // string starts with Y
                // iterate through characters past c[i]
                for (int j = i+1; j < c.length; j++)    
                    if (c[j] == 'X') // string ends with X
                        count++;     // increment the count
		
        return count;

    }
}
