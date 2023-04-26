/* https://leetcode.com/problems/trapping-rain-water/
Dynamic Programming

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/
public class WaterTrap {
    //======================MAIN====================
    // In the main method we simply test our algorithm
    // by specifying some input and making a call to
    // determine the result.

    public static void main(String[] args) {
      //  int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height = {4,2,0,3,2,5};
      
        System.out.println(trap(height));
    }

    /* ---------------------trap-----------------------
    This method takes an array of heights as described above. 
    The amount of water trapped in the barriers is computer and returned
    as an integer.
    Pre: given an array of nonnegative integers representing an elevation map.
    Post: the maximum amount of water that can be trapped is returned.
    */
    public static int trap(int[] height) {
        int n  = height.length; // number of entries in elevation map
        int[] leftBarrier = new int[n];  // holds maximum elevation from left (index 0) to index i.
        int[] rightBarrier = new int[n]; // holds maximum elevation from index i to right (index n-1)
        
        // the max left barrier is the max of the current elevation
        // and the maximum known left elevation (leftBarrier[i-1])
        leftBarrier[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftBarrier[i] = Math.max(leftBarrier[i-1], height[i]);

        }

        // the max right barrier is the max of the current elevation
        // and the maximum known right elevation (rightBarrier[i+1])
        rightBarrier[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            rightBarrier[i] = Math.max(rightBarrier[i+1], height[i]);
        }
       
        int total = 0; // total water trapped
        // sum up the water that can be trapped at each elevation
        // by finding the lowest barrier (to the left or right)
        // and subtracting the current elevation
        for (int i = 0; i < n; i++) {
            total += Math.min(leftBarrier[i], rightBarrier[i]) - height[i];
        }
        return total;
    }
}