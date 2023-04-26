/* This program prints all options for a truth of a length specified
by the user.
Dr. Becnel
 */

import java.util.Scanner;
import java.util.*;

public class TruthTable {
    //==================MAIN===================
    /* The main method asks the user for an integer. It produces
    to generate all truth table options of the given length. It
    then displays the options to the console.
     */
    public static void main(String[] args) {
        // read in the length of the bit strings from the user (console)
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of propositions: ");
        int length = input.nextInt();

        // line break
        System.out.println();

        // get the list of bit strings
        LinkedList<String> list = truthTable(length);

        // iterate through the list and display the strings
        Iterator<String> itr = list.iterator();
        System.out.println("The " + (int) Math.pow(2,length) + " options " + length + " are: " );
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        input.close();
    } // end main

    //------------------------------truthTable------------------------------
    /* This method produces all truth table options of a given length and returns
    the strings in a list.
    Pre : given a non-negative integer
    Post: all options of length n are recursively generated and returned
     */
    private static LinkedList<String> truthTable(int n) {
        // base case if n is 0 return an empty string
        if (n == 0) {
            LinkedList<String> list = new LinkedList<String>();
            list.add("");
            return list; 
        }
        else {
            // create an empty list to hold the  strings
            LinkedList<String> list = new LinkedList<String>();

            // get all bit strings of length n - 1 (
            LinkedList<String> smallerStrings = truthTable(n-1);

            // for each bit string of length n-1 add T and F
            // to the back of the bit strings and add
            // the new bit string to the bit String List
            Iterator<String> itr = smallerStrings.iterator();
            while (itr.hasNext()) {
                String s= itr.next();
                list.add(s+"T");
                list.add(s+"F");
            }
            // return the bit string list
            return list;
        }  // end else
   } //end
} //end class