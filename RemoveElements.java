// https://leetcode.com/problems/remove-element/
public class RemoveElements {

    public static void main(String[] args) {
        int[] nums = { 0,1,2,2,3,0,4,2 };
        System.out.println(new RemoveElements().removeElement(nums, 2));
        printArray(nums);
        System.out.println();

        int[] nums1 = { 3,2,2,3 };
        System.out.println(new RemoveElements().removeElement(nums1, 3));
        printArray(nums1);
        System.out.println();

        int[] nums2 = { 1 };
        System.out.println(new RemoveElements().removeElement(nums2, 1));
        printArray(nums2);
        System.out.println();

        int[] nums3 = { 3,3 };
        System.out.println(new RemoveElements().removeElement(nums3, 1));
        printArray(nums3);
        System.out.println();


        int[] nums4 = { 3,5 };
        System.out.println(new RemoveElements().removeElement(nums4, 5));
        printArray(nums4);
        System.out.println();

        int[] nums5 = { 3,5 };
        System.out.println(new RemoveElements().removeElement(nums5, 3));
        printArray(nums5);
        System.out.println();

        int[] nums6 = {2, 2, 3};
        System.out.println(new RemoveElements().removeElement(nums6, 2));
        printArray(nums6);
        System.out.println();

    }

    public static void printArray(int[] nums) {
        for (int n : nums)
            System.out.print(n + " ");
        System.out.println();
    }

    public int findBack(int[] nums, int val, int start) {
        for (int i = start; i >= 0; i--)
            if (nums[i] != val) 
                return i;
        return -1; // not found
    }

    public int findForward(int[] nums, int val, int start) {
        for (int i = start; i < nums.length; i++)
            if (nums[i] == val)
                return i;
        return -1; // all are val
    }
    
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        
        
        int removeIndex = findBack(nums, val, nums.length-1);
        if (removeIndex == -1) // entire array has value
            return 0;

        int goodIndex = findForward(nums, val, 0);
        if (goodIndex == -1) // no bad values
            return nums.length; // entire array is good

        while ( goodIndex < removeIndex) {
            // swap elements
            int temp = nums[goodIndex];
            nums[goodIndex] = nums[removeIndex];
            nums[removeIndex] = temp;
            
            int remove = findBack(nums, val, removeIndex - 1);
            if (remove == -1) // no more elements to remove 
                return goodIndex;
            else
                removeIndex = remove;

            int good = findForward(nums, val, goodIndex+1);
            if (good == -1) // no more good elememnts
                return goodIndex;
            else
                goodIndex = good;
            
        }
        

        return goodIndex;
        
    }
    
}
