/* https://leetcode.com/problems/wildcard-matching/  (Dynamic Programming)

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

 

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
*/

import java.util.regex.*;



public class WildCardMatch {
    public static  boolean isMatch(String s, String t) {
        StringBuilder p = new StringBuilder();
        char[] pattern = t.toCharArray();
        for (int i = 0; i < t.length(); i++)
            if (pattern[i] == '*') {
                 p.append("\\w*");
            }
            else if (pattern[i] == '?')
                p.append('.');
            else 
                p.append(pattern[i]);
        System.out.println(s + "  " + p.toString());
        return Pattern.matches( p.toString(),s );
    }

    public static boolean match(String s, String p) {
        // split patterns at wild cards.
        int n = s.length();
        int m = p.length();
        
        // visited[i][j] = true 
        // if pattern up to j matches the string up to position i
        boolean visited[][] = new boolean[n+1][m+1];
        
        // empty string matches empty pattern (true)
        visited[0][0] = true;
        
        
        // essentially this will be true for empty string
        // and a pattern of all *, e.g. ****
        // once something else is detected in the pattern it will
        // stay false and set everything after as false
        for(int j=1;j<=m;j++) {
            if(p.charAt(j-1) == '*') {
                visited[0][j] = visited[0][j-1];
            }
        }
        
        // move throughout the string
        for(int i=1;i<=n;i++) {
            // move throughout the pattern
            for(int j=1;j<=m;j++) {
                // if the pattern character matches string character or wildcard
                // then set to true if previous pattern (j-1) matched previous string (i-)
                // otherwise remains false
                if(p.charAt(j-1) =='?' || p.charAt(j-1) == s.charAt(i-1)) {
                    visited[i][j] = visited[i-1][j-1];
                // for * // it can be used to match rest of string
                // we set to true if pattern up to j matched string up to i-1 (* can match with any new character)
                // or string up to i matched pattern to j-1 (here * matches empty string)
                } else if(p.charAt(j-1) == '*') {
                    visited[i][j] = visited[i-1][j] || visited[i][j-1];
                }
            }
        }
        // entire length of pattern and string matches
        return visited[n][m];
    }   

    public static void main(String[] args) {
        String s = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba";
        String t = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";
        //String s = "aacdabdefa";
        //String t = "a*fa";
        System.out.println(match(s,t));
    }
}
