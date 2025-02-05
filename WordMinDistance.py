'''
https://leetcode.com/problems/word-search/
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
'''
class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] == word[0]:
                    pos = {(r,c)}
                    if self.dfs(board, r,c, word[1:], pos):
                        return True
                
        return False 
    
    def dfs(self, board, r,c, word, positions):
        if len(word) == 0:
            return True 
        
        num_rows = len(board)
        num_cols = len(board[0])
        
        for dr, dc in [(0,1), (1,0), (0,-1), (-1,0)]:
            new_r = r + dr
            new_c = c + dc 
            if 0 <= new_r < num_rows and 0 <= new_c < num_cols and board[new_r][new_c] == word[0]:
                pos = (new_r, new_c)
                if pos not in positions:
                    positions.add(pos)
                    if self.dfs(board, new_r, new_c, word[1:], positions):
                        return True
                    positions.remove(pos)
                    
        return False
    
if __name__ == "__main__":
    s = Solution()
    print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],  "ABCCED"))
    print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],  "SEE"))
    print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],  "ABCB"))