'''
https://leetcode.com/problems/unique-binary-search-trees-ii/description/
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

 

Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
 '''

from TreeNode import TreeNode
 
class Solution:
    def generateTrees(self, n: int) -> list[TreeNode]:
        return self.generateTreesUtil(list(range(1,n+1)))
    
    
    def generateTreesUtil(self, nums : list[int]) -> list[TreeNode]:
        if len(nums) == 0:
            return [None]
        if len(nums) == 1:
            return [TreeNode(nums[0])]
        
        trees = []
        for i in range(len(nums)):
            all_left = self.generateTreesUtil(nums[0:i])
            all_right = self.generateTreesUtil(nums[i+1:len(nums)])
            for tl in all_left:
                for tr in all_right:
                    root = TreeNode(nums[i])
                    root.left = tl 
                    root.right = tr
                    trees.append(root)
       
        return trees 
    
    def inorderTraversal(self, root: TreeNode) -> list[int]:
        if root is None:
            return []
        else:
            res = self.inorderTraversal(root.left)
            res.append(root.val)
            res = res + self.inorderTraversal(root.right)
            return res


if __name__ == "__main__":
    trees = Solution().generateTrees(3)
    for t in trees:
        print(Solution().inorderTraversal(t))
        
    for n in range(1,9):
        print(len(Solution().generateTrees(n)))