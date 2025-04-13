''' https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.'''

class Solution:
    def removeDuplicates(self, nums: int) -> int:
        index = 0
        start = 0
        while index < len(nums):
            current = nums[index]
            count = 0
            while index < len(nums) and nums[index] == current:
                count += 1
                index += 1
            nums[start] = current
            if count >= 2:
                nums[start + 1] = current
                start += 2
            else:
                start += 1
        return start
    
if __name__ == "__main__":
    # Example usage:
    nums = [1, 1, 1, 2, 2, 3]
    solution = Solution()
    k = solution.removeDuplicates(nums)
    print(f"Length of modified array: {k}")
    print(f"Modified array: {nums[:k]}")
    
    nums = [0,0,1,1,1,1,2,3,3]
    solution = Solution()
    k = solution.removeDuplicates(nums)
    print(f"Length of modified array: {k}")
    print(f"Modified array: {nums[:k]}")
    
    nums = [1,1,1,1,1,1,1,1,1]
    solution = Solution()
    k = solution.removeDuplicates(nums)
    print(f"Length of modified array: {k}")
    print(f"Modified array: {nums[:k]}")
    
    
    nums = [1]
    solution = Solution()
    k = solution.removeDuplicates(nums)
    print(f"Length of modified array: {k}")
    print(f"Modified array: {nums[:k]}")
    
    nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]
    solution = Solution()
    k = solution.removeDuplicates(nums)
    print(f"Length of modified array: {k}")
    print(f"Modified array: {nums[:k]}")