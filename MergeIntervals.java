import java.util.ArrayList;

class MergeIntervals {

    // A utility function to swap two elements
    /**
     * The given array is n x 2 and we are sorting
     * by the first element
     * @param arr - double array (n x 2)
     * @param i - index of first element to swap
     * @param j - index of second eleemtn to swap with the first
     */
    static void swap(int[][] arr, int i, int j) {
        int temp0 = arr[i][0];
        int temp1 = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = temp0;
        arr[j][1] = temp1;
    }

    /*
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     */
    static int partition(int[][] arr, int low, int high) {

        // pivot
        int pivot = arr[high][0];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j][0] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*
     * The main function that implements QuickSort
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     */
    static void quickSort(int[][] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Function to print an array
    static void printArray(int[][] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.println(arr[i][0] + " " + arr[i][1]);

        System.out.println();
    }

    public static int[][] merge(int[][] arr) {

        // sort the array of intervals by the first element
        quickSort(arr, 0, arr.length - 1);

        // holds the intervals to be inserted into the array 
        // to return
        ArrayList<Integer> ints = new ArrayList<Integer>();
        
        // current interval
        int a = arr[0][0];
        int b = arr[0][1];

        int k = 1; // loop variable
        // this could be converted to a for loop
        while (k < arr.length) {
            // comparison interval
            int c = arr[k][0];
            int d = arr[k][1];

            // compare [a,b] to [c,d]
            if (c <= b) {
                b = Math.max(b,d);
            } else {
                // no interval overlap
                // so keep [a,b] and
                // compare [c,d] to the next interval
                ints.add(a);
                ints.add(b);
                a = c;
                b = d;
            }
            k++; // compare to next interval in the array
        }
        // when down add the final (possibly merged) interval
        ints.add(a);
        ints.add(b);

        // convert the elements a1,b1,a2,b2,a3,b3, ....
        // in the array list to an nx2 array
        // [a1, b1], [a2, b2], [a3, b3], ....
        int[][] merged = new int[ints.size()/2][2];
        
        for (int i = 0; i < ints.size()/2; i++) {
            merged[i][0] = ints.get(2*i);
            merged[i][1] = ints.get(2*i+1);
        }
        
        return merged;
    }

    // Driver Code
    public static void main(String[] args) {
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = {{4,5}, {1,4}};
        int[][] intervals ={{1,4},{1,5}};
        

        int[][] m = merge(intervals);

        System.out.println();
        printArray(m, m.length);
    }
}
