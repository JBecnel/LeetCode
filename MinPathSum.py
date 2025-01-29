#https://leetcode.com/problems/minimum-path-sum/description/
'''
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

 

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
'''
class Solution:
    def minPathSum(self, grid: list[list[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        for r in range(1,m):
            grid[r][0] = grid[r][0] + grid[r-1][0]

        for c in range(1,n):
            grid[0][c] = grid[0][c] + grid[0][c-1]

        for r in range(1,m):
            for c in range(1, n):
                grid[r][c] = grid[r][c] + min(grid[r-1][c], grid[r][c-1])
        
        return grid[m-1][n-1]
    
if __name__ == "__main__":
    s = Solution()
    print(s.minPathSum([[1,3,1],[1,5,1],[4,2,1]]))
    print(s.minPathSum([[11]]))