public class PermutationSequence {
    //----------------------getPermutation-----------------
    /* The following method generates the kth permutation
    of the numbers {1,2,3, ... , n}.
    Pre : given two integers n where 1 <= n <= 9
    and 1 <= k <= 9!.
    Post: the kth permutation (lexicographically) of the numbers
    {1,2,3...,n} is returned as a string.
    */
    public static String getPermutation(int n, int k) {
        // this line 0-indexes the permutations
        // e.g
        // index 0   1   2   3    4     5
        // perm 123 132  213 231  312   321
        k = k - 1;

        // holds the numbers making up the permutations
        // index: 0 1 2 .... n-1
        // values:1 2 3 .... n
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i+1;

        // there are n choices for the first number 
        // and each number is the beginning of  (n-1)! permutations
        int factN = fact(n-1);
        
        // index for next number in the permutation
        //  1 <= k <= n!
        // k / (n-1)! tell us which number is first
        int index = k/ factN;
        
        // the position (k) for the next part of the permutation
        // for example if we want the 8 permutation of [1,2,3,4]
        // we know this starts with 2, since 8/3! = 1 (index of 2)
        // for the remaining numbers [1,3,4] we want the 8 mod 3! = 2nd permutation, i.e. 143
        int pos = k % factN; 
        
        // start the permutations and mark the first number as used in the permutation
        String perm = "" + nums[index];
        nums[index] = -1; // mark it as used

        // we repeat the above logic to find the remainder of the permutation
        // until all numbers in the nums list {1,2,3,...,n} are used.
        for (int i = n-1; i > 0; i--) {
            //System.out.println("i: "+ i + " factN: " + factN + " index " + index  + " pos " + pos + " perm " + perm);
            //for (int j = 0; j < nums.length; j++)
            //    System.out.print(nums[j]);
            //System.out.println();

            factN = factN / i; // traverses through (n-2)!, (n-3)!, ....
            index = pos / factN; // see logic above
            pos = pos % factN;  /// see logic above

            // this is the one change to the above
            // if we have already used a number
            // then we use the next availabe number
            int next = findNum(index, nums);

            perm = perm + next; // add the number ot the permutation
        }
        return perm;
    }

    //------------------findNum-------------------
    // This method finds the next available number in the list of numbers.
    // Entries that are already used are marked with -1. 
    // Pre : pos - 0-indexed position of next number to pull from the list
    //       nums - array of integers [1,2,...n] where used numbers
    //       are marked with -1
    // Post: the available integer at the given position is returned
    public static int findNum(int pos, int[] nums) {
        // we have to find the active number in position
        // eg. pos = 1, nums = [-1 -1 3 -1 4 -1 5 6] would return 4
        int index = -1;
        while (pos >= 0) {
            // go on to check next number
            index = index + 1;
        
            // everytime we find a available number, reduce the position by 1
            if (nums[index] != -1)
                pos = pos - 1;
        }
        
        // nextNum holds the return value (next number in the permutation)
        // so we can mark it as -1
        int nextNum = nums[index];
        nums[index] = -1; // mark it as used

        return nextNum;
    }

    // Computes n! for n >= 0
    public static int fact(int n) {
        int fact = 1;
        for (int i =2; i <=n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        //int[] nums = {-1, 2, 3, 4, 4, -1, 5, 6};
        for (int i = 1; i <= 24; i++)
            System.out.println(getPermutation(4, i));
        //System.out.println(getPermutation(4,7));
        System.out.println(getPermutation(9, fact(9)));
        System.out.println(getPermutation(1, 1));
    }
}
