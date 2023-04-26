/* Dr. Becnel   4/2/2022
https://leetcode.com/problems/climbing-stairs/description/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

/* Idea: the total to get the stair is the sum of the
total of getting to the previous stair and the 2nd to last stair
C[n] = C[n-1] + C[n-2]
*/
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
//Memory Usage: 39.3 MB, less than 81.63% of Java online submissions for Climbing Stairs
class ClimbingStair {
    public static int climb(int n) {
        int a = 1;
        int b = 1;
        int total = 1;
        for (int i = 2; i <= n; i++) {
            total = a + b;
            b = a;
            a = total;
        }

        return total;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Total " + climb(n));
    }

}