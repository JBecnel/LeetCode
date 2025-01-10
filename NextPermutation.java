//https://leetcode.com/problems/next-permutation/description/
public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[]{1,2,3};

        for (int i = 1; i <= 6; i++) {
            np.nextPermutation(nums);
            np.printArray(nums);
        }

         nums = new int[]{1};
        for (int i = 1; i <= 2; i++) {
            np.nextPermutation(nums);
            np.printArray(nums);
        }

        nums = new int[]{1,1,5};
        for (int i = 1; i <= 4; i++) {
            np.nextPermutation(nums);
            np.printArray(nums);
        }
    }

    public  void printArray(int[] nums) {
        for (int n : nums)
            System.out.print(n + " ");
        System.out.println();
    }
    public void nextPermutation(int[] nums) {
    
        // let i be the largets index such that a_i < a_i+1
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i != -1) {
            // find the largest index j such that a_i < a_j (note: j >= i+1 )
            int j = nums.length-1;
            while (nums[i] >= nums[j])
                j--;

            // swap a_i and a_j
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int left = i+1;
        int right = nums.length-1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    
}
