'''
Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.'''
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        m, n = len(s), len(t)
        # dp[i][j] = number of distinct subsequences of s[:i] which equals t[:j]
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(m + 1):
            dp[i][0] = 1  # empty string is a subsequence of any string
        for i in range(1, m + 1):
            for j in range(1, n+1):
                if j < i:
                    dp[i][j] = 0
                if s[i-1] == t[j-1]:
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
                else:
                    dp[i][j] = dp[i-1][j]
                    
        return dp[m][n]
    
    
if __name__ == "__main__":
    s = "rabbbit"
    t = "rabbit"
    sol = Solution()
    print(sol.numDistinct(s, t))  # Output: 3
    
    s= "babgbag"
    t = "bag"
    print(sol.numDistinct(s, t))  # Output: 5
    
    s = "aaaaaaaaab"
    t = "ab"
    print(sol.numDistinct(s, t))  # Output: 9