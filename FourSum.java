import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
public class FourSum {
    public static void main(String[] args) {
        //Input: nums = [1,0,-1,0,-2,2], target = 0
        //Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int[] ex1 = new int[]{1,0,-1,0,-2,2};
        System.out.println(new FourSum().fourSum(ex1, 0));
        //Input: nums = [2,2,2,2,2], target = 8
        //Output: [[2,2,2,2]]
        int[] ex2 = new int[]{2,2,2,2};
        System.out.println(new FourSum().fourSum(ex2, 8));

        int[] ex3 = new int[]{2,2,2,2, 2, 2, 2};
        System.out.println(new FourSum().fourSum(ex3, 8));

        int[] ex4 = new int[]{-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        System.out.println(new FourSum().fourSum(ex4, 0));

        int[] ex5 = new int[]{1000000000,1000000000,1000000000,1000000000};
        System.out.println(new FourSum().fourSum(ex5, -294967296));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> solutionSet = new HashSet<ArrayList<Integer>>();
        long sum = 0;           
        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    sum = nums[i];
                    sum += nums[j];
                    sum +=  nums[left];
                    sum += nums[right];
                    if (sum == target) {
                        // check that solution is different
                            solution = new ArrayList<Integer>();
                            solution.add(nums[i]);
                            solution.add(nums[j]);
                            solution.add(nums[left]);
                            solution.add(nums[right]);
                            
                            if (!solutionSet.contains(solution)) {
                                sol.add(solution);
                                solutionSet.add(solution);
                            }
                       
                        left++;
                        right--;                       
                    }
                    else if (sum < target) 
                        left++;
                    else 
                        right--;             
                } // end while
            } // end for
        } // end end for
        return sol;
    } // end mehtod
}
