
import java.util.HashSet;

//https://leetcode.com/problems/happy-number/
/**
 * Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        int sum = 0;
        int num = n;
        // need to replace with a HashSet
        HashSet<Integer> nums = new HashSet<Integer>();
        while (sum != 1) {
            sum = sumDigits(num);
            System.out.println(sum);
            // add returns true if 
            // the set did NOT contain the element
            if (!nums.add(sum))
                return false;
            num = sum;
        }
        return true;
    }

    public static int sumDigits(int num) {
        int digit = 0;
        int sum = 0;
        
        while (num > 0) {
            digit = num % 10;
            sum = sum + digit * digit;
            num = num / 10;
            
        }
        return sum;
    }
    public static void main(String[] args) {
//      System.out.println(isHappy(19));
      System.out.println(isHappy(2));
    }
}

