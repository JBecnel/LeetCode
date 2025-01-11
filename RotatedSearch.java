// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class RotatedSearch {
    public static void main(String[] args) {
        RotatedSearch rs = new RotatedSearch();
    //     System.out.println(findMinIndex(new int[]{1,2,3,4,5}));
    //    System.out.println(findMinIndex(new int[]{6,7,1,2,3,4,5}));
    //     System.out.println(findMinIndex(new int[]{3,4,5,6,7,1,2}));
    //    System.out.println(findMinIndex(new int[]{3,4,5,6,7,8,1}));
    //    System.out.println(findMinIndex(new int[]{0,1,2,3,4,5}));
    //    System.out.println(findMinIndex(new int[]{6,7,0,1,2,3,4,5}));
    //     System.out.println(findMinIndex(new int[]{3,4,5,6,7,0,1,2}));
    //    System.out.println(findMinIndex(new int[]{2,3,4,5,6,7,8,1}));
        System.out.println(rs.search(new int[]{3,4,5,6,7,8,1}, 1));
        System.out.println(rs.search(new int[]{3,4,5,6,7,8,1}, 7));
        System.out.println(rs.search(new int[]{3,4,5,6,7,8,1,2}, 1));
        System.out.println(rs.search(new int[]{3,4,5,6,7,8,1,2}, 7));
        System.out.println(rs.search(new int[]{7,8,1,2, 3,4,5,6}, 1));
        System.out.println(rs.search(new int[]{7,8,1,2,3,4,5,6}, 7));
        System.out.println(rs.search(new int[]{7,8,1,2,3,4,5,6}, -2));
  
    }
    public int search(int[] nums, int target) {
        int k = findMinIndex(nums);
        if (k == 0)
            k = nums.length;

        int left = 0;
        int right = nums.length-1;
        int mid = (left + right)/2;
        int rotate = (mid + k) % nums.length;
        while (left <= right) {
            if (nums[rotate] == target)
                return rotate;
            else if (target < nums[rotate]) {
                right = mid  - 1;
                mid = (left + right)/2;
            } else { // nums[mid] < target
                left = mid + 1;
                mid = (left+right)/2;
            }
            rotate = (mid + k) % nums.length;
        }
    
        return -1;
    }
    public static int findMinIndex(int[]  nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = (left + right)/2;
        while (left < right) {
            if (nums[left] <= nums[mid] && nums[mid] <= nums[right])
                return left;
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
                mid = (left + right)/2;
            } else { // nums[mid] < nums[left]
                right = mid;
                mid = (left+right)/2;
            }
        }

        return (nums[left] <= nums[right] ? left : right);
    }
}
