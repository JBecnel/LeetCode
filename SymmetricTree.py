'''https://leetcode.com/problems/symmetric-tree/description/
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?'''
from TreeNode import TreeNode
class Solution:
    def matchTrees(self, rL : TreeNode, rR : TreeNode) -> bool:
        if rL is None and rR is None:
            return True
        if rL is None or rR is None:
            return False
        return (rL.val == rR.val) and self.matchTrees(rL.left, rR.right) and self.matchTrees(rL.right, rR.left)
    
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        if root.right is None and root.left is None:
            return True
        
        if root.right is None or root.left is None:
            return False
        
        return (root.right.val == root.left.val) and self.matchTrees(root.right,root.left)
    
if __name__ == "__main__":
    s = Solution()
    root = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(2, TreeNode(4), TreeNode(3)))
    print(s.isSymmetric(root)) # True
    root = TreeNode(1, TreeNode(2, None, TreeNode(3)), TreeNode(2, None, TreeNode(3)))
    print(s.isSymmetric(root)) # False
        