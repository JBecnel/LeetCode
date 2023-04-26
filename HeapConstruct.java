/* Dr. Becnel
This program reads an array from the user consisting of
integers. A message is printed to the console
indicating if the array is a heap or not.
 */

import java.util.Scanner; // for input/output


public class HeapConstruct {
    //==================MAIN====================
    public static void main(String[] args) {

        // get the number of elements from the array
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int numElements = console.nextInt();

        // read in the array elements
        System.out.println("Enter the elements of the array: ");
        int[] heap = new int[numElements+1];
        for (int i =1; i < heap.length; i++) {
            heap[i] = console.nextInt();
        }
        console.close();        

        maxHeap(heap);
        System.out.println("The max heap is:");
        for (int i = 1; i < heap.length; i++)
            System.out.print(heap[i] + " ");


        minHeap(heap);
        System.out.println();
        System.out.println("The min heap is:");
        for (int i = 1; i < heap.length; i++)
            System.out.print(heap[i] + " ");
    } // end main

    /**
     * This method turns an array into a min heap
     * @param h - integer array
     */
    public static void minHeap(int[] h) {
        for (int i = 1; i < h.length; i++)
            h[i] = -h[i];

        maxHeap(h);

        for (int i = 1; i < h.length; i++)
            h[i] = -h[i];
    }

    /**
     * This method turns an array into a max heap using a bottom up
     * construction (see page 229)
     * @param - integer array 
     */
    public static void maxHeap(int[] h) {
        int n = h.length-1;
        int k, v, j;
        boolean heap;
        for (int i = (int) Math.floor(n/2); i >= 1; i--) {
            k = i; 
            v = h[k];
            heap = false; 
            while (!heap && 2*k <=n) {
                j = 2*k;
                if (j < n) 
                    if (h[j]<h[j+1])
                        j++;
                
                if (v >= h[j])
                    heap = true;
                else {
                    h[k] = h[j];
                    k = j;
                }
            } // end while
            h[k] = v;
        } // end for
    }   
    
}