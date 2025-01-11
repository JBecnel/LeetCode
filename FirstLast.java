// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FirstLast {
    public static void main(String[] args) {
        FirstLast fl = new FirstLast();
        int[] nums = new int[]{5,7,7,8,8,10};
        fl.printArray(fl.searchRange(nums, 8));
        fl.printArray(fl.searchRange(nums, 6));
        fl.printArray(fl.searchRange(nums, 5));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] sol = new int[2];
        sol[0] = findLeft(nums,target);
        sol[1] = findRight(nums, target);
        return sol;
    }

    
    public  void printArray(int[] nums) {
        for (int n : nums)
            System.out.print(n + " ");
        System.out.println();
    }

    public int findLeft(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right)/2;
        while (left <= right) {
            if (nums[mid] == target)
                index = mid;
            if (target <= nums[mid]) {
                right = mid  - 1;
                mid = (left + right)/2;
            } else { // nums[mid] < target
                left = mid + 1;
                mid = (left+right)/2;
            }
        }
    
        return index;
    }

    public int findRight(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right)/2;
        while (left <= right) {
            if (nums[mid] == target)
                index = mid;
            if (target < nums[mid]) {
                right = mid  - 1;
                mid = (left + right)/2;
            } else { // nums[mid] <= target
                left = mid + 1;
                mid = (left+right)/2;
            }
        }
    
        return index;
    }
}
