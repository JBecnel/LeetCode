'''
Given a binary tree, determine if it is height-balanced.
'''

import TreeNode
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.isBalancedHelper(root) != -1
        
    def isBalancedHelper(self, root: TreeNode) -> int:
        if root is None:
            return 0
        else:
            left = self.isBalancedHelper(root.left)
            right = self.isBalancedHelper(root.right)
            if left == -1 or right == -1 or abs(left - right) > 1:
                return -1
            else:
                return max(left, right) + 1