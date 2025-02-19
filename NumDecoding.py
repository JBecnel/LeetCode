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
    def numDecodingsUtil(self, s : str, mem_func : list[int]) -> int:
        if mem_func[len(s)] > -1:
            return mem_func[len(s)]
        
        # reached the end, 1 string
        if len(s) == 0:
            mem_func[len(s)] = 1
            return 1
        
        num = int(s[0])
        # if num starts with 0, it is invalid
        if num == 0:
            mem_func[len(s)] = 0
            return 0
        # if one number (not zero), then we have 1 valid sequence
        if len(s) == 1:
            mem_func[len(s)] = 1
            return 1
        
        next = int(s[1])
        
        # starts with 1,2 and ends with 0, jump 2
        if (num <= 2) and (next == 0):
            mem_func[len(s)] = self.numDecodingsUtil(s[2:], mem_func)
            return mem_func[len(s)]
        # numbers from 10-26
        if (num == 1) or (num ==2 and next <= 6):
            mem_func[len(s)] = self.numDecodingsUtil(s[1:], mem_func) + self.numDecodingsUtil(s[2:], mem_func)    
            return mem_func[len(s)]
        # number 3-9
        mem_func[len(s)] = self.numDecodingsUtil(s[1:], mem_func) 
        return mem_func[len(s)]
        
    def numDecodings(self, s: str) -> int:
        mem_func = [-1] * (len(s)+1)  # memory function to avoid repeated calculations
        return self.numDecodingsUtil(s, mem_func)
            
if __name__ =="__main__":
    s = Solution()
    print(s.numDecodings("11106"))
    print(s.numDecodings("12"))
    print(s.numDecodings("226"))
    print(s.numDecodings("06"))
    print(s.numDecodings("111111111111111111111111"))