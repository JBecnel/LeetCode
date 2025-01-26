# https://leetcode.com/problems/spiral-matrix/
'''
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
'''

import numpy as np

class Solution:
    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        start_row = 0
        end_row = len(matrix)-1
        start_col = 0
        end_col = len(matrix[0])-1

        answer = []
        while start_row <= end_row and start_col <= end_col:
            answer = answer + [matrix[start_row][x] for x in range(start_col, end_col+1)]
            start_row = start_row+1
            answer = answer + [matrix[x][end_col] for x in range(start_row,end_row+1)]
            end_col = end_col -1
            answer = answer + [matrix[end_row][x] for x in range(end_col, start_col-1,-1)]
            end_row = end_row -1
            answer = answer + [matrix[x][start_col] for x in range(end_row,start_row-1,-1)]
            start_col = start_col+1
            
        size = len(matrix) * len(matrix[0])
        return answer[0:size]
    
if __name__ == "__main__":

    s = Solution()
    print(s.spiralOrder([[1,2,3],[4,5,6],[7,8,9]]))
    print(s.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]]))
    # 1,2,3,4,8,12,11,10,9,5,6,7

        