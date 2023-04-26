/* https://leetcode.com/problems/largest-rectangle-in-histogram/
First Method is O(n^2), second is O(n)

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
*/
import java.util.*;
public class MaxRectangleHistogram {
    public static int largestRectangleArea(int[] height) {
        int n = height.length;
        int[][] minRect = new int[n][];
        // minRect[i][j] - holds the minimum height of rect[j], rect[j+1], ...., rect[i]


        // create jagged arrays
        // 0,0
        // 1,0  1,1
        // 2.0, 2,1 22
        //....
        /// with minRect[i][i] holding only the height of rect[i]
        int max = 0; // holds the max rectangle value
        for (int i = 0; i < n; i++) {
            minRect[i] = new int[i+1]; 
            minRect[i][i] = height[i];
            max = Math.max(max, height[i]);
        }
        // at this stage max holds the value of tallest bar 
        // we now consider rectangles made from multiple bars
        // the area of each  is found by base x height were
        // base = # of histogram bars (i-j+1)
        // height is height of the minimum rectangle
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++) {
                minRect[i][j] = Math.min(minRect[i-1][j], height[i]);
                max = Math.max(max, minRect[i][j] * (i-j+1));
            }
        return max;
    }


    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length; //number of rectangles
        
        // the stack will hold indices of the bars
        // eg. [3,2,1] means that bar[3] >= bar[2] >= bar[1]
        Stack<Integer> stack = new Stack<>();
        
        // We need to track how far a bar can extend to the left
        // essentially how far left we can do until we hit  
        // a smaller bar
        // leftSmall[i] = k 
        // means bar[k] <= bar[i]...that is, k is the index 
        // of first bar on the left that has height less than bar[i] 
        int[] leftSmall = new int[n];
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            } 
            
            if(stack.isEmpty()) {
                leftSmall[i] = 0;
            } else {
                leftSmall[i] = stack.peek() + 1;
            }
            
            stack.push(i);
        }
        
        // Empty Stack for next iteration.
        while(!stack.isEmpty()) {
            stack.pop();    
        }   
        
        int[] rightSmall = new int[n];
        
        // Calculate the right smaller indexes.
        // We need to track how far a bar can extend to the right
        // essentially how far rgiht we can go until we hit  
        // a smaller bar
        // rightSmall[i] = k 
        // means bar[k] <= bar[i]...that is, k is the index 
        // of first bar on the right that has height less than bar[i] 
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                rightSmall[i] = n - 1;
            } else {
                rightSmall[i] = stack.peek() - 1;
            }
            
            stack.push(i);
        }
        
        int maxArea = 0;
        
        for(int i = 0; i < n; i++) {
            int currArea = (rightSmall[i] - leftSmall[i] + 1) * heights[i];
            maxArea = Math.max(currArea, maxArea);
        }
        
        return maxArea;
    }  

    public static void main(String[] args) {
        int[] heights = 
        //{ 2,1,5,6,2,3 };
        //{2,4};
        //{4,2};
        //{3,1,2};
        //{4};
        //{0,9};
        {0,1};
        //{1,1,1,1,1,1};
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleArea(heights));

    }
}
