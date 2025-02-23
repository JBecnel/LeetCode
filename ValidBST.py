'''
https://leetcode.com/problems/validate-binary-search-tree/
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
'''
import math 
from TreeNode import TreeNode
class Solution:
    def isValidBST(self, root : TreeNode, m = -math.inf, M = math.inf) -> bool:
        if root.left is None and root.right is None:
            return m < root.val < M 
        
        if root.left is None:
            return (m < root.val < M) and self.isValidBST(root.right, max(m, root.val), M)
        elif root.right is None:
            return (m < root.val < M) and self.isValidBST(root.left, m, min(M, root.val))
        else:
            return (m < root.val < M) and  self.isValidBST(root.left, m, min(M, root.val)) and  self.isValidBST(root.right, max(m, root.val), M)
            
    def isValid(self, root: TreeNode) -> bool:
        max_tree = self.findMaxTree(root)
        min_tree = self.findMinTree(root)
        return self.isValidUtil(root , max_tree, min_tree)
    
    def findMaxTree(self, root :TreeNode) -> TreeNode:
        if root.left is None and root.right is None:
            return TreeNode(root.val)
        else:
            if root.left is None:
                right_max = self.findMaxTree(root.right)
                return TreeNode(max(root.val, right_max.val), None, right_max)
            elif root.right is None:
                left_max = self.findMaxTree(root.left)
                return TreeNode(max(root.val, left_max.val), left_max, None)
            else:
                right_max = self.findMaxTree(root.right)
                left_max = self.findMaxTree(root.left)
                return TreeNode(max(root.val, left_max.val, right_max.val), left_max, right_max)
    
    def findMinTree(self, root :TreeNode) -> TreeNode:
        if root.left is None and root.right is None:
            return TreeNode(root.val)
        else:
            if root.left is None:
                right_min = self.findMinTree(root.right)
                return TreeNode(min(root.val, right_min.val), None, right_min)
            elif root.right is None:
                left_min = self.findMinTree(root.left)
                return TreeNode(min(root.val, left_min.val), left_min, None)
            else:
                right_min = self.findMinTree(root.right)
                left_min = self.findMinTree(root.left)
                return TreeNode(min(root.val, left_min.val, right_min.val), left_min, right_min)
            
    def isValidUtil(self, root : TreeNode, max_root : TreeNode, min_root : TreeNode) -> bool:
        if root.left is None and root.right is None:
            return True
        elif root.left is None:
            return (root.val < min_root.right.val) and self.isValidUtil(root.right, max_root.right, min_root.right)
        elif root.right is None:
            return (root.val > max_root.left.val) and self.isValidUtil(root.left, max_root.left, min_root.left)
        else:
            return (root.val > max_root.left.val) and (root.val < min_root.right.val) and self.isValidUtil(root.left, max_root.left, min_root.left) and self.isValidUtil(root.right, max_root.right, min_root.right)
        
from TreeNode import printTree
if __name__ == "__main__":
    tree = TreeNode()
    tree.insertValues([2,1,3])
    print(tree.inorderTraversal())
    print(Solution().isValidBST(tree))
    tree.val = 0
    print(Solution().isValidBST(tree))
    
    # True then False 
    tree = TreeNode()
    tree.insertValues([2,1,3,4])
    print(Solution().isValidBST(tree))
    tree.left.val = 4
    print(Solution().isValidBST(tree))
    
    tree = TreeNode()
    tree.insertValues([3,1,5,4,6])
    print(Solution().isValidBST(tree))
    #printTree(tree)
    print(tree.inorderTraversal())
    tree.right.left.val = 2
    printTree(tree)
    print(Solution().isValidBST(tree))
    
    tree = TreeNode(5, TreeNode(14, TreeNode(1)))
    printTree(tree)
    print(Solution().isValidBST(tree))
    