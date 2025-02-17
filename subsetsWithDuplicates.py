'''
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

'''
class Solution:
    def subsetsWithDup(self, nums: list[int]) -> list[list[int]]:
        num_freq = {}
        nums.sort()
        # find the frequency  of the numbers
        for n in nums:
            if n in num_freq:
                num_freq[n] += 1
            else:
                num_freq[n] = 1
        
        return  self.subsets(num_freq, len(nums))
                
    def subsets(self, freq : dict, k : int) -> list[list[int]]:
        all_combos = [[] ]
        
        for num in freq.keys():
            # for each number find all subsets with just that number
            combos = []
            for i in range(1,freq[num]+1):
                combos.append([num]*i)
            
            # find the cross product of previously constructed sets
            # with the new combos
            new_combos = all_combos.copy() 
            for c in combos:
                for a in all_combos:
                    new_combos.append(a+c)
            all_combos = new_combos
        return all_combos
            
if __name__ == "__main__":
    s = Solution()
    print([3]*4)
    print(s.subsetsWithDup([1,2,2]))
    print(s.subsetsWithDup([1,1,2,2]))
    print(s.subsetsWithDup([4,1,4]))
    print(s.subsetsWithDup([0]))
    print(s.subsetsWithDup([1,2,2,3,3,3]))
        