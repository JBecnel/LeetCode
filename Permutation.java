import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    
    public static void main(String[] args) {
        //int[] nums = {-1, 2, 3, 4, 4, -1, 5, 6};
         //System.out.println(getPermutation(4,7));
         Permutation pm = new Permutation();
        System.out.println(pm.permute(new int[]{3,2,1}));
        System.out.println(pm.permute(new int[]{0,1}));
        System.out.println(pm.permute(new int[]{1}));
    }

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int n = fact(nums.length);

        Integer[] intNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            intNums[i] = nums[i];

        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        solutions.add(Arrays.asList(intNums.clone()));
        for (int i = 2; i <= n; i++) {
            nextPermutation(intNums);
            List<Integer> perm = Arrays.asList(intNums.clone()); 
            solutions.add(perm);
        }
        return solutions;
    }
 
     // Computes n! for n >= 0
    public static int fact(int n) {
        int fact = 1;
        for (int i =2; i <=n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public void nextPermutation(Integer[] nums) {
    
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
    

