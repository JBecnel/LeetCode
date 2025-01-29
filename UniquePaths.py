class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [[1 for _ in range(n)] for _ in range(m)]


        for r in range(1,m):
            for c in range(1,n):
                grid[r][c] = grid[r-1][c] + grid[r][c-1]

        return grid[m-1][n-1]

if __name__ == "__main__":
    s = Solution()
    print(s.uniquePaths(3,7))
    print(s.uniquePaths(3,2))