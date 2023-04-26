
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.


Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

https://leetcode.com/problems/generate-parentheses/submissions/
Runtime: 2 ms, faster than 64.81% of Java online submissions for Generate Parentheses.
Memory Usage: 44.2 MB, less than 28.32% of Java online submissions for Generate Parentheses.

*/
import java.util.ArrayList;

class GeneratingParentheses {
    public static void main(String[] args) {
        ArrayList<String> p = generatingParentheses(4);
        System.out.println(p);
    }

    public static ArrayList<String> generatingParentheses(int n) {
        ArrayList<String> para = new ArrayList<String>();  
        String p = "("; // all start with 1 open (
        // we start with 1 opening and 2*n-1 characters remaining        
        generateNext(para, p, 1, 2*n-1);
        return para; // retrun the list
    }
    
    public static void generateNext(ArrayList<String> para, String p, int open, int remain) {
        // if we have k open ( and only k characters left in the string
        // then the rest must be )
        if (open == remain) {
            String s = p + ")".repeat(remain);
            //System.out.println("Added: "+ s + " remain: " + remain + " open: " + open);
            para.add(s );
        }
        else {
            // check to see if another ( is possible
            if (remain > open) {
                String op = p + "(";
                // add one (, which results in 1 more open and 1 fewer characters
                generateNext(para, op, open+1, remain-1);
            }
                
            // if we have one or more open, we can add a )
            if (open >= 1) {
                String cp = p + ")";
                // add a ) which closes one (  and leaves 1 fewer characters 
                generateNext(para, cp, open-1, remain-1);
            }
        }
        
    }
}