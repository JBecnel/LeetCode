'''
https://leetcode.com/problems/gray-code/description/
An n-bit gray code sequence is a sequence of 2n integers where:

Every integer is in the inclusive range [0, 2n - 1],
The first integer is 0,
An integer appears no more than once in the sequence,
The binary representation of every pair of adjacent integers differs by exactly one bit, and
The binary representation of the first and last integers differs by exactly one bit.
Given an integer n, return any valid n-bit gray code sequence.

 

Example 1:

Input: n = 2
Output: [0,1,3,2]
Explanation:
The binary representation of [0,1,3,2] is [00,01,11,10].
- 00 and 01 differ by one bit
- 01 and 11 differ by one bit
- 11 and 10 differ by one bit
- 10 and 00 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- 00 and 10 differ by one bit
- 10 and 11 differ by one bit
- 11 and 01 differ by one bit
- 01 and 00 differ by one bit
Example 2:

Input: n = 1
Output: [0,1]'''

class Solution:
    def grayCodeStr(self, n: int) -> list[int]:
        # Gray code is a binary numeral system where two successive values differ in only one bit.
        # [0,1]
        # [00, 01, 11, 10]  , add 0,1, then 1,0
        # [000, 001, 011, 010, 110, 111, 101, 100]
        # 000, 010, 011, 001, 101, 111, 110, 100
        # 000, 100, 101, 111, 011, 001, 010, 110
        if n == 1:
            return ["0", "1"]
        else:
            res = self.grayCodeStr(n-1)
            answer = []
            toggle = True
            for r in res:
                if toggle:
                    answer.append(r+"0")
                    answer.append(r+"1")
                else:
                    answer.append(r+"1")
                    answer.append(r+"0")
                toggle = not toggle
            return answer 
    
    def grayCode(self, n : int) -> list[int]:
        if n == 1:
            return [0,1]
        else:
            res = self.grayCode(n-1)
            answer = []
            toggle = True
            for r in res:
                # shift over and add 0 then 1
                if toggle:
                    answer.append(r << 1)
                    answer.append((r << 1) ^ 1)
                # shift over and add 1 then 0
                else:
                    answer.append((r << 1) ^ 1)
                    answer.append(r << 1)
                toggle = not toggle
            return answer
        
if __name__ == "__main__":
    s = Solution()
    print(s.grayCode(2))
    print(s.grayCode(3))
    print(s.grayCode(4))
