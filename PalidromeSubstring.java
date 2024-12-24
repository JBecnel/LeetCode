public class PalidromeSubstring {
    public static void main(String[] args) {
        PalidromeSubstring ps = new PalidromeSubstring();
        System.out.println(ps.longestPalindrome("abcabcdad"));
        System.out.println(ps.longestPalindrome("abccba"));
        System.out.println(ps.longestPalindrome("babad"));
        System.out.println(ps.longestPalindrome("cbbd"));
        System.out.println(ps.longestPalindrome("a"));
    }
    public String longestPalindrome(String s) {
        int[] ans = {0,0};  // holds max left and right indices
        int[] lr = {0,0};  // left and right indices
        int max = 0;       // holds max length seen thus far
        for (int i = 0; i < s.length(); i++) {
            lr = middleOut(s,i,i);  // work middle out with one character
            // check for improvement
            int current = lr[1] - lr[0];
            if (current > max)  {
                max = current;
                ans = lr.clone();
            }
            // if double letter, e.g. "aa" work middle out from there
            if (i < s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                lr = middleOut(s, i, i+1);
                // check for improvement and update if necessary
                current = lr[1]-lr[0];
                if (current > max) {
                    max = current;
                    ans = lr.clone();
                }
            }
        }
        // return the biggest substring
        return s.substring(ans[0], ans[1]+1);    
        
    }

    public int[] middleOut(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        l++; r--;
        int[] ans = {l,r};
        return ans; 

    }
    
}
