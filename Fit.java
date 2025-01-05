/* Dr. Becnel
This program takes an array of numbers between 0 and 1. The array is paritioned into
sets such that each set in the parition contains elements that total to 1 or less.

The original array is read from the console and the partition is displayed to the
console.
 */

import java.util.Scanner;

public class Fit {
    //===================MAIN====================
    /* This method reads an array of real numbers
    between 0 and 1 to the console.
    The array is paritioned and the parition is displayed
    to the console.
     */
    public static void main(String[] args) {
        // read in the number of elements in the array
        System.out.print("How many numbers are in the array: ");
        Scanner console = new Scanner(System.in);
        int numElements = console.nextInt();

        // read in the array elements
        System.out.println("Enter the members of the array (all between 0 and 1):");
        float[] nums = new float[numElements];
        for (int i = 0; i < numElements; i++)
            nums[i] = console.nextFloat();

        // parition the array using a greedy algorithm
        // and display them to the console
        float total = 0;
        System.out.print("{ ");
        for (int i = 0; i < numElements; i++) {
            total = total + nums[i];
            if (total <= 1)
                System.out.print(nums[i] + " ");
            else {
                System.out.println("}");
                total = nums[i];
                System.out.print("{ " + nums[i] + " ");
            }  // end else
        } // end for
        System.out.println("}");
        console.close();
    }  //end main
} // end class