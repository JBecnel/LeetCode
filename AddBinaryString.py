'''
https://leetcode.com/problems/add-binary/description/
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

'''
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        n = len(a)
        m = len(b)
        
        # pad with 0's to may the string equal length
        if n < m:
            a = "0" * (m - n) + a
        else:
            b = "0" * (n - m) + b
        
        index = 1
        s = ""
        carry = "0"
        while (index <= max(m,n)):
            if a[-index] == "1" and b[-index] == "1":
                s = carry + s
                carry = "1"
            elif a[-index] == "0" and b[-index] == "0": 
                s = carry + s
                carry = "0"
            else:
                if carry == "0":
                    s = "1" + s
                else:
                    s = "0" + s
            index += 1
        
        if carry == "1":
            return "1" + s
        else:
            return s   
    
if __name__ == "__main__":
    s = Solution()
    print(s.addBinary("11", "1"))
    print(s.addBinary("1010", "1011"))
    print(s.addBinary("0", "0"))
    print(s.addBinary("11101", "0"))