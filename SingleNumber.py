'''
https://leetcode.com/problems/single-number/
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
'''
class Solution:
    def singleNumber(self, nums: list[int]) -> int:
        num_set = set()
        for num in nums:
            if num in num_set:
                num_set.remove(num)
            else:
                num_set.add(num)
        return num_set.pop()
    
if __name__ == "__main__":
    nums = [4,1,2,1,2]
    solution = Solution()
    result = solution.singleNumber(nums)
    print(f"The single number is: {result}") # Output: 4
    
    nums = [1]
    solution = Solution()
    result = solution.singleNumber(nums)
    print(f"The single number is: {result}") # Output: 4
    
    nums = [2,2,1]
    solution = Solution()
    result = solution.singleNumber(nums)
    print(f"The single number is: {result}") # Output: 4
        
        