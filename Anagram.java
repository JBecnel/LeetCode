/* Dr. Becnel
This program determines if two strings are anagrams. 
The two strings are entered from the console and 
a message is displayed indicating if the strings are 
anagrams.
*/
import java.util.Scanner; // used to read from console

public class Anagram {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); // console input

        // get the two strings from the user
        System.out.println("Enter the first string: ");
        String firstInput = console.next();
        System.out.println("Enter the second string: ");
        String secondInput = console.next();

        // determine if the strings are anagrams and
        // display a message to the user
        if (Anagrams(firstInput, secondInput))
            System.out.println("The two strings are anagrams.");
        else 
            System.out.println("The two strings are not anagrams.");

    }
    
    /* This method determines if the two strings are anagrams.
       Pre : given two strings
       Post: true is returned if the strings are anagrams and false otherwise
    */
    public static boolean Anagrams(String s, String t) {
        // if the strings are different lengths then they are not anagrams.
        if (s.length() != t.length())   
            return false;

        char current = 'a'; // current letter in string
        for (int k = 0; k < s.length(); k++) {  // traverse first string
            current = s.charAt(k); // curent character in s
            
            int sCount = 0;  // # of times current character occurs in s
            int tCount = 0;  // # of times current character occurs in t
            
            for (int j = 0; j < s.length(); j++) {  // traverse the string
               // count number of times current character occurs in s and t
               if (current == s.charAt(j))       
                  sCount++;
               if (current == t.charAt(j))
                  tCount++;                
            }
            // if this is different, return false
            if (sCount != tCount)
              return false;
        }
        
        return true; // all letters in the first string have been found in the second string in the same quantity
    }
}