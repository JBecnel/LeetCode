// https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[]  nums = {2,3,6,7};
        System.out.println( new CombinationSum().combinationSum(nums, 8));
        int[] nums1 = {2,3,5};
        System.out.println(new CombinationSum().combinationSum(nums1, 8));

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combSum(candidates, target, 0);    
    }

    public static List<List<Integer>> combSum(int[] sorted, int target, int index) {
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        
        if (target == 0) {
            sol.add(new ArrayList<Integer>());
            return sol;
        }
    
    
        if (target < 0 || index >= sorted.length)
            return null;
        
    

        int limit = target / sorted[index];
        List<List<Integer>> reduced = new ArrayList<List<Integer>>();
        for (int i = 0; i <= limit; i++) {
            reduced = combSum(sorted, target - sorted[index] * i, index+1);
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
