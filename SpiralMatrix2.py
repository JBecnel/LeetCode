#https://leetcode.com/problems/spiral-matrix-ii/description/
'''
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
'''

class Solution:
    def generateMatrix(self, n: int) -> list[list[int]]:
        
 
        matrix = []
        for i in range(n):
            matrix.append([x for x in range(n*i+1, n*(i+1)+1)])

        start_row = 0
        end_row = len(matrix)-1
        start_col = 0
        end_col = len(matrix[0])-1

        num = 1
        for i in range(n//2+1):
            # go across row
            for x in range(start_col, end_col+1):
                matrix[start_row][x] = num
                num = num + 1
            start_row = start_row+1
            
            for x in range(start_row, end_row+1):
                matrix[x][end_col] = num 
                num = num + 1
            end_col = end_col - 1

            for x in range(end_col, start_col-1,-1):
                matrix[end_row][x] = num 
                num = num + 1
            end_row = end_row - 1

            for x in range(end_row,start_row-1,-1):
                matrix[x][start_col] = num 
                num = num + 1
            start_col = start_col + 1
            
                
        return matrix
    
if __name__ == "__main__":

    s = Solution()
    print(s.generateMatrix(3))
    print(s.generateMatrix(4))
    # 1,2,3,4,8,12,11,10,9,5,6,7

        