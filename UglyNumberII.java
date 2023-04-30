// https://leetcode.com/problems/ugly-number-ii/description/
// The basic idea is that numbers will be made in the order
// 2, 3, 2*2, 5, 2*3, 2*2*2, 2*5, 2*2*3, 3*5, 2*2*2*2, 2*3*3, 2*2*5, 2*2*2*3, 5*5
// We can approcha this directly by
// finding the first number previous when multiplied by 2, 3, 5 and exceeds the last number respecitvely.
/* That is, 
 * f(n) =min { 2* f(k2), 3*f(k3), 5*f(k5)} where k2, k3, k5 are such that
 * they are smallest index such that 2*f(k2), 3*f(k3), 5*f(k5) are than f(n)
 */
public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }
    public int nthUglyNumber(int n) {
        int[] nums = new int[Math.max(n, 5)];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        for (int k = 5; k < n; k++) {
                int times2 = findNext(2, nums, k);
                int times3 = findNext(3, nums, k);
                int times5 = findNext(5, nums, k);
                nums[k] = Math.min(Math.min(times2, times3), times5);
        }

        
        return nums[n-1];
        
    }
    
    public int findNext(int multiple, int[] nums, int index) {
        for (int i = 0; i <= index - 2; i++) {
            int value = nums[i] * multiple;
            if (value > nums[index-1])
                return value;
        }
        
        return multiple*nums[index-1]; // should never reach
    }
}
