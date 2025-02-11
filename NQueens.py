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
        if n == 1:
            return [["Q"]]
        
        if n == 2:
            return []
       
        invalid = set()  # stores invalid positions
        solutions = set()  # stores unique solutions
        solveQueensUtil(0, n, invalid, solutions, set())
        return convert(solutions, n)
        
# convert the set of solutions to the required format
def convert(solutions, n):
    result = []
    for sol in solutions:
        grid = [['.'] * n for _ in range(n)]
        for i, j in sol:
            grid[i][j] = 'Q'
        result.append([''.join(row) for row in grid])
    return result

# recursive function to solve the N-Queens problem
# bracktracking technique
def solveQueensUtil(row, n, invalid, solutions, solution):
    if row == n:
        solutions.add(tuple(solution)) 
    else:    
        for c in range(n):
            if not ((row, c) in invalid):
                sol = solution.copy()
                sol.add((row,c))
                
                # mark row, column and diagonals as invalid
                inv = invalid.copy()
                for i in range(n):
                    for j in range(n):
                        if i == row or j == c or abs(i-row) == abs(j-c):
                            inv.add((i, j))
                
                solveQueensUtil(row + 1, n, inv, solutions, sol)
                    
    

if __name__ == "__main__":
    s = Solution()
    print(s.solveNQueens(4))
    print(s.solveNQueens(3))
    
    print(s.solveNQueens(2))
    print(s.solveNQueens(1))
    
        