/* https://leetcode.com/problems/jump-game-ii/description/
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. 
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*/

public class Jump {
  public static void main(String[] args) {
    Jump jp = new Jump();
    System.out.println(jp.jump(new int[]{2,3,1,1,4}));
    System.out.println(jp.jump(new int[]{2,3,0,1,4}));
    System.out.println(jp.jumpback(new int[]{2,3,1,1,4}));
    System.out.println(jp.jumpback(new int[]{2,3,0,1,4}));

  } 
  public int jump(int[] nums) {
    int[] sol = new int[nums.length];
    for (int i = 1; i < sol.length; i++)
        sol[i] = Integer.MAX_VALUE-1;
    

    for (int i = 0; i < nums.length; i++) {
        for (int j = 1; j <= nums[i]; j++) {
            if (i + j < sol.length)
                sol[i+j] = Math.min(sol[i] + 1, sol[i+j]);
        }
    }
    return sol[nums.length-1];
  }
  
  public int jumpback(int[] nums) {
    int[] sol = new int[nums.length];
    for (int i = 1; i < sol.length; i++)
        sol[i] = -1;
    
    return jumpback(nums, sol, nums.length-1);
  }

  public int jumpback(int[] nums, int[] sol, int index) {
    // caching
    if (sol[index] != -1)
        return sol[index];

    sol[index] = Integer.MAX_VALUE;
    for (int i = 0; i < index; i++) {
        if (nums[i] >= index - i) {
            int prev = jumpback(nums, sol, i) + 1; 

            if (prev < sol[index])
                sol[index] = prev;
        }
    }
    return sol[index];
  }

  public int jumpgreedy(int[] nums) {
    
      int numJumps = 0; // total jumps
      int dest = 0;     // destination on most recent jump
      int reached = 0; // where we have reach 

      for (int i = 0; i < nums.length - 1; i++) {
          reached = Math.max(reached, nums[i]+i);
          if (i == dest) {
              numJumps++;
              dest = reached;
          }
      }
      return numJumps;
}
}
