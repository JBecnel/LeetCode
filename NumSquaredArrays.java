/*/ https://leetcode.com/problems/number-of-squareful-arrays/
An array is squareful if the sum of every pair of adjacent elements is a perfect square.

Given an integer array nums, return the number of permutations of nums that are squareful.

Two permutations perm1 and perm2 are different if there is some index i such that perm1[i] != perm2[i].

 

Example 1:

Input: nums = [1,17,8]
Output: 2
Explanation: [1,8,17] and [17,8,1] are the valid permutations.
Example 2:

Input: nums = [2,2,2]
Output: 1
 

Constraints:

1 <= nums.length <= 12
0 <= nums[i] <= 109
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NumSquaredArrays {
    public static void main(String[] args) {
        //int[] nums = {-1, 2, 3, 4, 4, -1, 5, 6};
         //System.out.println(getPermutation(4,7));
        NumSquaredArrays pm = new NumSquaredArrays();

        System.out.println(pm.numSquarefulPerms(new int[]{2,2,2,2,2,2,2,2,2,2}));
        System.out.println(pm.numSquarefulPerms(new int[]{5,11,5,4,5}));
        System.out.println(pm.numSquarefulPerms(new int[]{1,17,8}));
        System.out.println(pm.numSquarefulPerms(new int[]{2,2,2}));
        System.out.println(pm.numSquarefulPerms(new int[]{1,1,8,1,8}));
        System.out.println(pm.numSquarefulPerms(new int[]{99,62,10,47,53,9,83,33,15,24}));
   
    }
    // branch and bound algorithm
    public int numSquarefulPerms(int[] nums) {
        if (nums.length == 1)
            return perfectSquare(nums[0]) ? 1 : 0;

        HashSet<ArrayList<Integer>> perms = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> perm = new ArrayList<Integer>();


        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        HashSet<Integer> distinct = new HashSet<Integer>();
        for (int n : nums) {
            distinct.add(n);
            if (count.containsKey(n))
                count.replace(n, count.get(n)+1);
            else 
                count.put(n, 1);
        }
        
        // find a pair that is perfect square
        for (Integer n : distinct) {
            perm = new ArrayList<Integer>();
            perm.add(n);
            HashMap<Integer, Integer> hashClone = (HashMap<Integer,Integer>) count.clone();
            hashClone.replace(n, hashClone.get(n)-1);
            if (hashClone.get(n) == 0)
                hashClone.remove(n);
            buildPerm(nums.length, hashClone, perm, perms);
        }
        System.out.println(perms);

        // HashSet<ArrayList<Integer>> hash = new HashSet<ArrayList<Integer>>();
        // for (ArrayList<Integer> p : perms)  {
        //     ArrayList<Integer> numList = new ArrayList<Integer>();
        //     for (Integer k : p) {
        //         numList.add(nums[k]);
        //     }
        //     hash.add(numList);
        // }
        
        // System.out.println(hash);
         return perms.size();
    
    }

    public void buildPerm(int len, HashMap<Integer, Integer> count, ArrayList<Integer> perm, HashSet<ArrayList<Integer>> perms) {
        
        if (perm.size() == len) {
            perms.add(perm);
        }

        int previous = perm.get(perm.size()-1);
        for (Integer n : count.keySet())
            if ( count.get(n) != 0 && perfectSquare(previous+n)) {        
                ArrayList<Integer> copy =  (ArrayList<Integer>) perm.clone();
                copy.add(n);
                HashMap<Integer, Integer> hashClone = (HashMap<Integer,Integer>) count.clone();
                hashClone.replace(n, hashClone.get(n)-1);
                buildPerm(len, hashClone, copy, perms);
            }   
    }




    public int numSquarefulPerms1(int[] nums) {
        if (nums.length == 1)
            return perfectSquare(nums[0]) ? 1 : 0;

        HashSet<ArrayList<Integer>> perms = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> perm = new ArrayList<Integer>();

        // find a pair that is perfect square
        for (int i =0; i < nums.length; i++) {
            perm = new ArrayList<Integer>();
            perm.add(i);
            buildPerm(nums, perm, perms);
        }
        //System.out.println(perms);

        HashSet<ArrayList<Integer>> hash = new HashSet<ArrayList<Integer>>();
        for (ArrayList<Integer> p : perms)  {
            ArrayList<Integer> numList = new ArrayList<Integer>();
            for (Integer k : p) {
                numList.add(nums[k]);
            }
            hash.add(numList);
        }
        
        //System.out.println(hash);
        return hash.size();
    
    }

    public void buildPerm(int[] nums, ArrayList<Integer> perm, HashSet<ArrayList<Integer>> perms) {
        if (perm.size() == nums.length) {
            perms.add(perm);
        }

        int previous = perm.get(perm.size()-1);
        for (int i = 0; i < nums.length; i++)
            if (!perm.contains(i) && perfectSquare(nums[previous]+nums[i])) {        
                ArrayList<Integer> copy =  (ArrayList<Integer>) perm.clone();
                copy.add(i);
                buildPerm(nums, copy, perms);
            }   
    }


    public int numSquarefulPerms2(int[] nums) {
        // if only one element, retrun the element
        if (nums.length == 1)
            return perfectSquare(nums[0]) ? 1 : 0;

        HashSet<ArrayList<Integer>> perms = new HashSet<ArrayList<Integer>>();

        ArrayList<Integer> perm = new ArrayList<Integer>();

        // find a pair that is perfect square
        int previous = -1;
        int i = 0; 
        while (i < nums.length) {
            
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
            
            i++;
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
    
  
    
}
