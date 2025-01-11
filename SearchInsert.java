// https://leetcode.com/problems/search-insert-position/
public class SearchInsert {
    public static void main(String[] args) {
        SearchInsert si = new SearchInsert();
        int[] nums = {1,3,5,7,9};
        for (int i = 0; i < 10; i++)
        System.out.println(i + " " + si.searchInsert(nums, i));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right)/2;
        while (left <= right) {
            if (nums[mid] == target)
                return mid;
            if (target < nums[mid]) {
                right = mid  - 1;
            } else { // nums[mid] < target
                left = mid + 1;
            }

            if (left <= right)
                mid = (left + right)/2;
        }
    
        return (target < nums[mid]) ? mid : mid + 1;
    }
}
