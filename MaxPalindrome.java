import java.util.Scanner;

public class MaxPalindrome {
    public static void main(String[] args) {
        // read the integer from the console
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the integer: ");
        int number = console.nextInt();

        // find the max palindrome and display the number
        // to the console
        int max = maxPalindrome(number);
        System.out.println("The maximal palindrome is " + max);

        console.close();
    }

    /**Given an integer with n digits, this method creates
     * the maximal palindrome from the digits of the given number 
     * @param num - a postive integer
     * @return an integer representing the maximal palindrome
     */
    public static int maxPalindrome(int num) {
        int[] dist = new int[10];
        
        // first we count the number of each digit
        int digit = 0;
        while (num != 0) {
            digit = num % 10;
            dist[digit]++;
            num = num / 10;
        }

        //anytime we have 2 of a digit we put one at the front
        //and one at the end
        int firstHalf = 0;
        for (int k = 9; k >= 0; k--) {
            int numK = dist[k] / 2;   //
            dist[k] = dist[k] % 2; // number of digit k left

            for (int d = 1; d <= numK; d++) {
                firstHalf = firstHalf * 10 + k; 
            }
        }

        // check to see if we have a digit occurring once we can put in the middle
        int k = 9;
        while (k >= 0 && dist[k] != 1) {
            k--;
        }
        
        int max = firstHalf;
        if (k != -1)
            max = firstHalf * 10 + k;

        
        while (firstHalf != 0) {
            digit = firstHalf % 10;
            max = max * 10 + digit;
            firstHalf = firstHalf / 10;
        }
        return max; 
    }
}