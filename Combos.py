'''
https://leetcode.com/problems/combinations/description/
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n
'''
class Solution:
    def combine(self, n: int, k: int) -> list[list[int]]:
        if k == 1:
            return [[i] for i in range(1, n+1)]
        else:
            combos = self.combine(n, k-1)
            new_combos = [ ]
            for c in combos:
                for i in range(c[-1]+1, n+1):
                    new_combos.append(c+[i])
            return new_combos
        
if __name__ == "__main__":
    print(Solution().combine(4, 2))
    print(Solution().combine(10,1))
    print(Solution().combine(3,3))
    