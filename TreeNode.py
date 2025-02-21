# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
    def insertValues(self, data : list[int]):
        self.val = data[0]
        for i in range(1,len(data)):
            self.insert(data[i])
        
    def insert(self, data):
        if data < self.val:
            if self.left is None:
                self.left = TreeNode(data)
            else:
                self.left.insert(data)
        elif data > self.val:
            if self.right is None:
                self.right = TreeNode(data)
            else:
                self.right.insert(data)
            
    def inorderTraversal(self) -> list[int]:
        if self is None:
            return []
        else:
            res = [ ]
            if not (self.left is None):
                res = self.left.inorderTraversal()
            res.append(self.val)
            if not (self.right is None):
                res = res + self.right.inorderTraversal()
            return res
        
def printTree(node : TreeNode, level=0):
    if node != None:
        printTree(node.left, level + 1)
        print(' ' * 4 * level + '-> ' + str(node.val))
        printTree(node.right, level + 1)

