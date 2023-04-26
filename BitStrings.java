/* This program prints all bit strings of a length specified
by the user.
Dr. Becnel
 */

import java.util.Scanner;
import java.util.*;

public class BitStrings {
    //==================MAIN===================
    /* The main method asks the user for an integer. It produces
    to generate all bit strings of the given length. It
    then displays the bit strings to the console.
     */
    public static void main(String[] args) {
        // read in the length of the bit strings from the user (console)
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the bit strings: ");
        int length = input.nextInt();

        // line break
        System.out.println();

        // get the list of bit strings
        LinkedList<String> bitStringList = bitStrings(length);

        // iterate through the list and display the strings
        Iterator<String> itr = bitStringList.iterator();
        System.out.println("The " + (int) Math.pow(2,length) + " bit strings of length " + length + " are: " );
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    } // end main

    //------------------------------bitStrings------------------------------
    /* This method produces all bit strings of a given length and returns
    the strings in a list.
    Pre : given a non-negative integer
    Post: all bit strings of length n are recursively generated and returned
     */
    private static LinkedList<String> bitStrings(int n) {
        // base case if n is 0 return an empty string
        if (n == 0) {
            LinkedList<String> bitStringList = new LinkedList<String>();
            bitStringList.add("");
            return bitStringList; 
        }
        else {
            // create an empty list to hold the bit strings
            LinkedList<String> bitStringList = new LinkedList<String>();

            // get all bit strings of length n - 1 (
            LinkedList<String> smallerStrings = bitStrings(n-1);

            // for each bit string of length n-1 add 0 and 1
            // to the front of the bit strings and add
            // the new bit string to the bit String List
            Iterator<String> itr = smallerStrings.iterator();
            while (itr.hasNext()) {
                String s= itr.next();
                bitStringList.add("0" + s);
                bitStringList.add("1" + s);
            }
            // return the bit string list
            return bitStringList;
        }  // end else
   } //end
} //end class