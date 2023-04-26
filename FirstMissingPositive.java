/*
https://leetcode.com/problems/first-missing-positive/
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
*/
public class FirstMissingPositive {

    public static void main(String[] args) {
        //int[] nums = { 3, 4, -1, 1 };
        int[] nums = {4,2,1,-1,-4,0 };
        //int[] nums = {3,4,5,6};
        // int[] nums = {1,1};
        //int[] nums = {1,2,3};
        System.out.println(missingPositive(nums));
    }

    public static int missingPositive(int[] nums) {

        // example [4,2,1,-1,-4,0]
        int n = nums.length;
        // based on the length missing number must be in the set
        // {1,2,3,...,n}
    
        int i = 0;      // index for the array
        while (i < n) {
            if (nums[i] >= 1 && nums[i] <= n) {// if the number is in the set
                int pos = nums[i] - 1; // position corresponding to nums[i]
                // IF number not in correct position AND number is different than
                // number in swap position
                if (pos != i  && nums[i] != nums[pos]) { 
                    // swap nums[i] and nums[pos]
                    int temp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = temp;
                } else // if number is in correct position or same as number in swap position
                    i = i + 1; // go to next number
            } else {  // if number is not in range {1,2,...n}
                i = i + 1; // move to next element
            }
        }
        // example: [1 2 -1 4 -4 0 ]
        //printArray(nums);
      
        // find the first position
        // that does not have the correct element
        for (i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        //if all positions are in correct spot, eg. [1,2,3...n] then return
        // next positive
        return n+1; // all numbers in correct positions [1,2,3]
    }

    // This simple method prints the numbers in the array.
    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }
}