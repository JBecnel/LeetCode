'''https://leetcode.com/problems/triangle/
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104'''
import math
class Solution:
    def minimumTotal(self, triangle: list[list[int]]) -> int:
        if len(triangle) == 1:
            return triangle[0][0]
        sum = triangle.copy()
        
        for i in range(1, len(triangle)):
            for j in range(len(triangle[i])):
                if j == 0:
                    sum[i][0] = sum[i-1][0] + triangle[i][0]
                elif j == len(triangle[i]) - 1:
                    sum[i][j] = sum[i-1][j-1] + triangle[i][j]
                else:
                    sum[i][j] = min(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j]
        
        min_val = math.inf            
        for j in range(len(triangle[-1])):
            if sum[-1][j] < min_val:
                min_val = sum[-1][j]
        
        return min_val
    
    
if __name__ == "__main__":
    s = Solution()
    triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    print(s.minimumTotal(triangle)) # 11
    triangle = [[-10]]
    print(s.minimumTotal(triangle)) # -10
    triangle = [[-1],[2,3],[1,-1,-3]]
    print(s.minimumTotal(triangle)) # -1
    triangle = [[-1],[2,3],[1,-1,-3],[4,1,8,3]]
    print(s.minimumTotal(triangle)) # 1
    triangle = [[-1],[2,3],[1,-1,-3],[4,1,8,3],[1,1,1,1,1]]
    print(s.minimumTotal(triangle)) # 2 