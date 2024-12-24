// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashMap;

public class LongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<Character, Integer>();
        int[] longestFromLeft = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int lastLocation = 0;
           
            if (lastSeen.containsKey(ch)) {
                lastLocation = lastSeen.get(ch);
                if (i > 0)
                    longestFromLeft[i] = Math.min(i- lastLocation, longestFromLeft[i-1] + 1);
                else
                    longestFromLeft[0] = 1;
            }   else {
                if (i > 0)
                    //longestFromLeft[i] = Math.min(i+1, longestFromLeft[i-1]+1);
                    longestFromLeft[i] = longestFromLeft[i-1]+1;
                else 
                    longestFromLeft[0] = 1;
            }
            lastSeen.put(ch, i);
        }

        int max = 0;
        for (int val : longestFromLeft)
            if (val > max) 
                max = val;
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        int ans = ls.lengthOfLongestSubstring("aaabcccbbd");
        System.out.println(ans);
        System.out.println(ls.lengthOfLongestSubstring("bbbbb"));
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
    }
}
