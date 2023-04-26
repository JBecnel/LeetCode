import java.util.Arrays;

/**
 * Problem from LeetCode
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * You can return the answer in any order.
 */

class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 5, 15 };
        //int[] nums = {3,2,4};
        int target = 17;
        int[] solution = twoSum(nums, target);
        System.out.println(solution[0] + " " + solution[1]);
    }
    /**
     * This method sorts the array first and then finds
     * the numbers in the array that add to the target.
     * @param nums - an array of integers
     * @param target - target that two numbers of the array add up to
     * @return an array of length two holding the indices of the solutions
     */
    public static int[] twoSum(int[] nums, int target) {
        // create a sorted copy of the array
        int[] numbers = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numbers);

        // use the sorted array to create a O(n)
        // loop to find two numbers that add to the target
        int i = 0; int j = numbers.length -1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] < target) 
                i++;  // make the num bigger by moving to the right
            else if (numbers[i] + numbers[j] > target)
                j--; // make the sum smaller by moving to the left.
        }
        // i and j will hold the position of the numbers in the sorted
        // array that add to the target
        
        // now we need to find where these numbers are in the 
        // unsorted arrray
        int[] solution = new int[]{-1,-1};
        int k = 0;  // traverses the array
        int found = 0; // tracks how many of the two numbers have been located
        // while the second number has not been located
        while (found < 2) {
           if (numbers[i] == nums[k] && solution[0] == -1) { 
                solution[0] = k;
                found++;
           }
           if (numbers[j] == nums[k] && solution[0] != k) {
                solution[1] = k;
                found++;
           }
           k++;
        }
        // solution will have the location
        // of the two numbers that add to the target
        return solution;
    }


    /**
     * This method takes an unsorted array of integers and a target integer
     * The method returns the indices of the two numbers in the array
     * that add to the target.
     * Pre: exactly one solution and cannot use the element twice
     * Post: an array of length two is return containing the indices
     * of the solution
     * 
     * This one does not presort and is thus n^2 runtime
     */
    public static int[] twoSumNoSort(int[] nums, int target) {
        int[] solution = new int[2];
        boolean found = false;
        int i = 0;
        while (i < nums.length && !found) {
            int j = 0;
            while (j < nums.length && !found) {
                if (nums[i] + nums[j] == target) {
                    solution[0] = i;
                    solution[1] = j;
                    found = true;
                }
                j++;
            }
            i++;
        }
        return solution;
    }
}