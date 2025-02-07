'''
# https://leetcode.com/problems/pascals-triangle/description/
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:
'''
class Solution:
    def generate(self, numRows: int) -> list[list[int]]:
        triangle = [[1]]

        prev_row = triangle[0]
        for r in range(1,numRows):
            row = [1]
            for i in range(0, len(prev_row)-1):
                row.append(prev_row[i]+ prev_row[i+1])
            row.append(1)
            prev_row = row

            triangle.append(prev_row)

        return triangle
    
if __name__ == "__main__":
    s = Solution()
    print(s.generate(5))
    print(s.generate(1))
    print(s.generate(2))