# https://leetcode.com/problems/jump-game/
'''
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
 
Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
'''

class Solution:
    def canJump(self, nums: list[int]) -> bool:
        can_reach = [False] * len(nums)
        can_reach[0] = True
        print(can_reach)
        print(nums)
        for i in range(len(nums)):
            if can_reach[i]:
                jump_size = nums[i]
                if (i + jump_size) >= len(nums)-1: # reached the last index
                    return True
                else: # mark reachable as True and proceed
                    can_reach[i+1:i+jump_size+1] = [True]*jump_size

        return False
    
if __name__ == "__main__":
    s = Solution()
    print(s.canJump([2,3,1,1,4]))
    print(s.canJump([3,2,1,0,4]))