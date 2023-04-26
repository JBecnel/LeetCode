/* 
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/

class MedianTwoArrays {
    public static void main(String[] args) {
        int[] a = {1,3,10,12,141};
        int[] b = {2,4,6,8};
        System.out.println(findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int l1 = 0; int r1 = m-1;
        int l2 = 0; int r2 = n-1;
        
        int pos1, pos2 = 0;

        int b = Math.max(nums1[m-1], nums2[n-1]);
        int a = Math.min(nums1[0], nums2[0]);

        pos1 = (l1+r1)/2;
        pos2 = (l2+r2)/2;
            
        while (a < b) {             
            System.out.println("pos 1,2  " + pos1 + " " + pos2);

            if (nums1[pos1] > nums2[pos2]) {
                r1 = pos1;
                l2 = pos2;
                a = Math.max(nums2[pos2], a);
                b = Math.min(nums1[pos1], b);                 
                
                pos1 = (l1+r1)/2 + ((l1+r1) % 2);
                pos2 = (l2+r2)/2;
            
            
            }
            else {
                r2 = pos2;
                l1 = pos1;                
                a = Math.max(nums1[pos1], a);
                b = Math.min(nums2[pos2], b);
                
                pos1 = (l1+r1)/2;
                pos2 = (l2+r2)/2 + ((l2+r2) % 2);
            
            }
            System.out.println("pos:  1: " + "("+ l1 + ", " + r1 + ")" +  "       2: " + "("+ l2 + ", " + r2 + ")" +  "m,M: " + a + " " + b);  

            

        }
        
        
        return nums2[pos2];
        
    }
}


// 1 2 3 4 5
// 6 7 8 9