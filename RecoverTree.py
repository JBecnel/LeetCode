'''
https://leetcode.com/problems/recover-binary-search-tree/
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

 

Example 1:


Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:


Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.'''
from TreeNode  import TreeNode
class Solution:
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        
        """
        if root is None:
            return
        
        if not (root.left is None) and root.left.val > root.val:
           # swap root.left.val and root.val
           root.left.val, root.val = root.val, root.left.val
        elif not (root.right is None) and root.right.val < root.val:
            # swap root.right.val and root.val
            root.right.val, root.val = root.val, root.right.val
        else:
            self.recoverTree(root.left)
            self.recoverTree(root.right)
            
if __name__ == "__main__":
    s = Solution()
    root = TreeNode(1, None, TreeNode(3, None, TreeNode(2)))
    s.recoverTree(root)
    print(root.inorderTraversal()) # [3,1,null,null,2]
    root = TreeNode(3, TreeNode(1), TreeNode(4, None, TreeNode(2))) 
    s.recoverTree(root)
    print(root.inorderTraversal()) # [2,1,4,null,null,3]
    root = TreeNode(1, TreeNode(3), TreeNode(2))
    s.recoverTree(root)
    print(root.inorderTraversal()) # [3,1,null,null,2]
    root = TreeNode(3, TreeNode(1), TreeNode(4, TreeNode(2), None))
    s.recoverTree(root)
    print(root.inorderTraversal()) # [2,1,4,null,null,3]
    root = TreeNode(3, TreeNode(1), TreeNode(4, TreeNode(2), TreeNode(5)))
    s.recoverTree(root)
    print(root.inorderTraversal()) # [2,1,4,null,null,3]
        