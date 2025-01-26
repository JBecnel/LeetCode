# https://leetcode.com/problems/maximum-subarray/description/
'''
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

'''
class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        mf = [nums[0]]
        #index = [0]
        max = nums[0]
        #max_index = 0
        for i in range(1,len(nums)):
            if mf[i-1] >= 0:
                mf.append(mf[i-1]+nums[i])
            else:
                mf.append(nums[i])
            '''
            if nums[i] > 0:  
                if mf[i-1] <= 0:  # (+, -)
                    mf.append(nums[i])
                    #index.append(i)
                else:              # +, +
                    mf.append(mf[i-1]+nums[i])
                    #index.append(index[i-1])
            else:
                if mf[i-1] >= 0:   # - +
                    mf.append(mf[i-1]+nums[i])
                    #index.append(index[i-1])
                else:             # - -
                    mf.append(nums[i])
                    #index.append(i)
            '''
            if mf[i] > max:
                max = mf[i]
                #max_index = i

        #print(nums[index[max_index]:max_index+1])

        return max
    
if __name__ == "__main__":
    s = Solution()
    print(s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
    print(s.maxSubArray([1]))
    print(s.maxSubArray([5,4,-1,7,8]))