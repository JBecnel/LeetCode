'''
https://leetcode.com/problems/unique-binary-search-trees/description/
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19'''

class Solution:
    def numTrees(self, n: int) -> int:
        mem_func = [-1]*(n+1)
        mem_func[0] = 1
        return self.numTreesUtil(mem_func,n)
    
    def numTreesUtil(self, mem_func : list[int], n : int):
        if mem_func[n] == -1:
            res = 0
            for i in range(0, n):
                res = res + self.numTreesUtil(mem_func, i) * self.numTreesUtil(mem_func, n-1-i)
                
            mem_func[n] = res 
            
        return mem_func[n]
    
    
if __name__ == "__main__":
    s = Solution()
    for i in range(1, 20):
        print(s.numTrees(i))