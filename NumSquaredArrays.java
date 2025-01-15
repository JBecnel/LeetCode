// https://leetcode.com/problems/number-of-squareful-arrays/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumSquaredArrays {
       public static void main(String[] args) {
        //int[] nums = {-1, 2, 3, 4, 4, -1, 5, 6};
         //System.out.println(getPermutation(4,7));
         NumSquaredArrays pm = new NumSquaredArrays();
        System.out.println(pm.numSquarefulPerms(new int[]{1,17,8}));
        System.out.println(pm.numSquarefulPerms(new int[]{2,2,2}));
        System.out.println(pm.numSquarefulPerms(new int[]{1,1,8,1,8}));
        System.out.println(pm.numSquarefulPerms(new int[]{99,62,10,47,53,9,83,33,15,24}));
   
    }


    public int numSquarefulPerms(int[] nums) {
        // if only one element, retrun the element
        if (nums.length == 1)
            return perfectSquare(nums[0]) ? 1 : 0;

        return findPair(nums);
    }

    public int findPair(int[] nums) {
        HashSet<ArrayList<Integer>> perms = new HashSet<ArrayList<Integer>>();

        ArrayList<Integer> perm = new ArrayList<Integer>();

        // find a pair that is perfect square
        int previous = -1;
        for (int i = 0; i < nums.length; i++) {
            
            perm = new ArrayList<Integer>();
            perm.add(i);
            previous = i;
            boolean added = true;
            while (perm.size() != nums.length && added) {
                added = false;
                for (int j = 0; j < nums.length; j++)
                    if (!perm.contains(j) && perfectSquare(nums[previous]+nums[j])) {
                        previous = j;
                        perm.add(j);
                        added =true;
                        break;
                    }        
            
            }
            // we should be able to add on each iteration
            if (perm.size() == nums.length) 
                perms.add(perm);
        }

        // once we have complete perms
        System.out.println(perms);
        
        HashSet<ArrayList<Integer>> hash = new HashSet<ArrayList<Integer>>();
        for (ArrayList<Integer> p : perms)  {
            ArrayList<Integer> numList = new ArrayList<Integer>();
            for (Integer k : p) {
                numList.add(nums[k]);
            }
            hash.add(numList);
        }
        
        System.out.println(hash);
        return hash.size();
            
        
    }


    
    public boolean perfectSquare(int num) {
        double r = Math.sqrt(num);
        return Math.round(r) == r;
    }
    
     // Computes n! for n >= 0
    public static int fact(int n) {
        int fact = 1;
        for (int i =2; i <=n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    
}
