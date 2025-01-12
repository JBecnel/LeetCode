//https://leetcode.com/problems/combination-sum-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    
    public static void main(String[] args) {
        int[]  nums = {10,1,2,7,6,1,5};
        System.out.println( new CombinationSumII().combinationSum(nums, 8));
        int[] nums1 = {2,5,2,1,2};
        System.out.println(new CombinationSumII().combinationSum(nums1, 5));

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length/2; i++) {
            int temp = candidates[i];
            candidates[i] = candidates[candidates.length-1-i];
            candidates[candidates.length-1-i] = temp;
        }
        return combSum(candidates, target, 0);    
    }

    public static List<List<Integer>> combSum(int[] sorted, int target, int index) {
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        
        // numbers are bigger than 1, so the base case
        // we return an empty list if the target is 0
        if (target == 0) {
            sol.add(new ArrayList<Integer>());
            return sol;
        }
    
        // no solution for negative targets
        if (target < 0 || index >= sorted.length)
            return null;
        
    

        int count = 0;
        while (index + count < sorted.length && sorted[index] == sorted[index+count] )
            count++;

        List<List<Integer>> reduced = new ArrayList<List<Integer>>();
        for (int i = 0; i <= count; i++) {

            reduced = combSum(sorted, target - sorted[index] * i, index+count);
            if (reduced != null) {
                for (List<Integer> lst : reduced) {
                    for (int j = 1; j <= i; j++) 
                        lst.add(sorted[index]);
                }
                sol.addAll(reduced);
            }
        }
        return sol;
    }
}
