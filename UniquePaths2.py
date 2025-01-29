# https://leetcode.com/problems/unique-paths-ii/description/
'''
63. Unique Paths II
Medium
Topics
Companies
Hint
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.'''
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: list[list[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        grid = [[1 for _ in range(n)] for _ in range(m)]

        if obstacleGrid[0][0] == 1:
            return 0
      
        for r in range(1,m):
            if obstacleGrid[r][0] == 1:
                grid[r][0] = 0
            else:
                grid[r][0] = grid[r-1][0]

        for c in range(1,n):
            if obstacleGrid[0][c] == 1:
                grid[0][c] = 0
            else: 
                grid[0][c] = grid[0][c-1]

        for r in range(1,m):
            for c in range(1,n):
                if obstacleGrid[r][c] == 1:
                    grid[r][c] = 0 
                else:
                    grid[r][c] = grid[r-1][c] + grid[r][c-1]

        return grid[m-1][n-1]

if __name__ == "__main__":
    s = Solution()
    #print(s.uniquePathsWithObstacles([[0,0,0],[0,1,0],[0,0,0]]))
    #print(s.uniquePathsWithObstacles([[0,1],[0,0]]))
    #print(s.uniquePathsWithObstacles([[0,0],[0,1]]))
    #print(s.uniquePathsWithObstacles([[0,0]]))
    print(s.uniquePathsWithObstacles([[1]]))