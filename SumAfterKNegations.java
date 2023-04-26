import java.util.Arrays;
public class SumAfterKNegations {

    public int sum(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }
        return total;
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        
        // if all numbers are nonnegative
        // then the first number will
        // toggle and k times ()
        if (nums[0] > 0) {
            if (k % 2 == 0)
                return sum(nums);
            else {
                nums[0] = -nums[0];
                return sum(nums);
            }
        }
        // we toggle as many negative that exits (up to k)
        int i = 0;
        while (i < Math.min(k,nums.length) && nums[i] < 0) {
            nums[i] = -nums[i];
            i++;
        }

        // if we used up all the negatives
        if (i == k)
            return sum(nums);
        else {
            // find the min in the first k characters
            int minIndex = 0;
            for (int j = 1; j <= Math.min(i, nums.length-1); j++)
                if (nums[j] < nums[minIndex])
                    minIndex = j;

            int numberOfNegatioinsLeft = k-i;

            if (numberOfNegatioinsLeft % 2 != 0)
                nums[minIndex] *= -1;
            return sum(nums);

        }
    }

    public static void main(String[] args) {
        int[] nums = {-3,1,-1,2};
        System.out.println(new SumAfterKNegations().largestSumAfterKNegations(nums, 1));
    }
}
