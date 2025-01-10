/**
 * Problem from:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array
 * nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not
 * matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
    
        int spot = 0;
        int index = 0;
        while (index < nums.length) {
            int j = index + 1;
            while (j < nums.length && nums[j] == nums[index]) {
                    j++;
            }
            
            nums[spot] = nums[index];
            spot = spot + 1;
            index = j;

        }
        return spot;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
        System.out.println();
    }
}
