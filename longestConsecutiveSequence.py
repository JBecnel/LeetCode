'''
# https://leetcode.com/problems/longest-consecutive-sequence/description/
# 
# Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3'''

class Solution:
    def longestConsecutive1(self, nums: list[int]) -> int:
        num_set = set(nums)
        longest_sequence = 0
        for x in nums:
           if x-1 not in num_set:
                seq = 1
                y = x + 1 
                while y in num_set:
                    seq += 1
                    y += 1
                longest_sequence = max(longest_sequence, seq)
        
        return longest_sequence
    
    
    
    def longestConsecutive(self, nums: list[int]) -> int:
        max_seq = 0
        seq_lengths = {}  #  dictionary to track sequence lengths
        
        for num in nums:            
            if num not in seq_lengths:
                left = seq_lengths.get(num - 1, 0)   # Length of consecutive sequence ending at num-1
                right = seq_lengths.get(num + 1, 0)  # Length of consecutive sequence starting at num+1
                curr_length = left + right + 1       # Total length of the new sequence
                
                
                seq_lengths[num] = curr_length
                max_seq = max(max_seq, curr_length)
                
                # Update the boundaries of the sequence with the new total length
                # This ensures the endpoints reflect the entire merged sequence length.
                if left > 0:
                    seq_lengths[num - left] = curr_length
                if right > 0:
                    seq_lengths[num + right] = curr_length
        return max_seq
                
if __name__ == "__main__":
    s = Solution()
    print(s.longestConsecutive([100,4,200,1,3,2]))
    