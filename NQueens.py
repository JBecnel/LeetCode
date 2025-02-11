'''
# https://leetcode.com/problems/n-queens/description/
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9'''

class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        grid = [['.'] * n for _ in range(n)]
        return self.solveQueensUtil(n, grid)
    
    
    def solveQueensUtil(self, n, grid):
        if n == 0:
            return [grid]
        
        solutions = []
        for i in range(len(grid)):
            for j in range(len(grid)):
                if self.isSafe(i, j, grid):
                    grid[i][j] = 'Q'
                    solutions += self.solveQueensUtil(n - 1, grid)
                    grid[i][j] = '.'
                    
        return solutions
        
    def isSafe(self, row, col, grid):
        