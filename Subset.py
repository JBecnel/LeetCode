'''
# https://leetcode.com/problems/subsets/description/
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
'''
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        sets = [[]]
        num_sets = 1 << len(nums)  # 2^n
        for n in range(1, num_sets):
            set = []    
            i = 1        
            for k in range(0, len(nums)):
                if (n & i > 0):
                    set.append(nums[k])
                i = i << 1 # shift bit to the left
            sets.append(set)
        return sets 