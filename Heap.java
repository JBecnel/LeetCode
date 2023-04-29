/* Dr. Becnel
This program reads an array from the user consisting of
integers. A message is printed to the console
indicating if the array is a heap or not.
 */

import java.util.Scanner; // for input/output

public class Heap {
    //==================MAIN====================
    public static void main(String[] args) {

        // get the number of elements from the array
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int numElements = console.nextInt();

        // read in the array elements
        System.out.println("Enter the elements of the array: ");
        int[] heap = new int[numElements];
        for (int i =0; i < heap.length; i++) {
            heap[i] = console.nextInt();
        }

        // print a message to the console
        if (isHeap(heap))
            System.out.println("The array is a heap.");
        else
            System.out.println("The array is not a heap.");
        
        console.close();
    } // end main

    //----------------isHeap-----------------
    /*  This method determines if a given array is a heap.
        Pre : given an array of integers
        Post: returns true if the array represents a heap
        and false otherwise
     */
    public static boolean isHeap(int[] array) {
        // start at the end of the array and go to the array[1]
        for (int i = array.length -1; i > 0; i--) {
            int parent = (i-1)/2; // find the index of the parent
            if (array[i] > array[parent]) // if the parent is smaller, return false
                return false;
        }
        return true;  // if all elements check out return true
    }
}