'''
# https://leetcode.com/problems/binary-tree-inorder-traversal/description/
Given the root of a binary tree, return the inorder traversal of its nodes' values.


Example 1:

Input: root = [1,null,2,3]

Output: [1,3,2]

Explanation:

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]

Explanation:

Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100'''

from TreeNode import TreeNode
class Solution:
    def inorderTraversal(self, root: TreeNode) -> list[int]:
        if root is None:
            return []
        else:
            res = self.inorderTraversal(root.left)
            res.append(root.val)
            res = res + self.inorderTraversal(root.right)
            return res
        

if __name__ == "__main__":
    root = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(6), TreeNode(7))), TreeNode(3, None, TreeNode(8, TreeNode(9), None)))
    s = Solution()
    print(s.inorderTraversal(root))
    
    print(s.inorderTraversal(None))
    print(s.inorderTraversal(TreeNode(1)))
    print(s.inorderTraversal(TreeNode(1, None, TreeNode(2, TreeNode(3), None))))
        