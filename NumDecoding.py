'''
https://leetcode.com/problems/decode-ways/
However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: s = "12"

Output: 2

Explanation:

"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:

Input: s = "226"

Output: 3

Explanation:

"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:

Input: s = "06"

Output: 0

Explanation:

"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06"). In this case, the string is not a valid encoding, so return 0.

 

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).'''

class Solution:
    def numDecodings(self, s : str) -> int:
        if len(s) == 0:
            return 0
        
        num = int(s[0])
        if num == 0:
            return 0
        
        if len(s) == 1:
            return 1
        
        next = int(s[1])
        
        if (num <= 2) and (next == 0):
            return self.numDecodings(s[2:])
        
        if (num == 1) or (num ==2 and next <= 6):
            return 1+ self.numDecodings(s[1:]) + self.numDecodings(s[2:])    
        
        return self.numDecodings(s[1:]) 
        
    def numDecodings2(self, s: str) -> int:
        if len(s) == 0:
            return 0
        elif len(s) == 1:
            return 1
        else:
            count = self.numDecodings(s[1:])
            if s[0] == '0':
                return 0
            elif s[0] == "1":
                if s[1] == '0':
                    return self.numDecodings(s[2:])
                else:
                    return count  + self.numDecodings(s[2:])
            elif s[0] == "2":                
                if s[1] != '7' and s[1] != '8' and s[1] != '9':
                    return count + self.numDecodings(s[2:])
                elif s[1] == '0':
                    return self.numDecodings(s[2:])
                else:
                    return count
            else:
                return count
            
if __name__ =="__main__":
    s = Solution()
    print(s.numDecodings("11106"))
    print(s.numDecodings("12"))
    print(s.numDecodings("226"))
    print(s.numDecodings("06"))