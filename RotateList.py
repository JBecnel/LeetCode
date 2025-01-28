'''
https://leetcode.com/problems/rotate-list/
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109

'''
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def printList(self):
        s = ""
        current = self 
        while not (current is None):
            s = s + str(current.val) + " "
            current = current.next 
        
        print(s)

    def createList(nums : list[int]):
        node = ListNode(nums[0])
        head = node 
        for i in range(1, len(nums)):
            nextnode = ListNode(nums[i])
            node.next = nextnode
            node = nextnode

        return head

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None or k == 0:
            return head
        
        # count the number of elements in the list
        # grab the last element in the list
        current = head
        count = 0
        while not (current.next is None):
            count = count + 1
            current = current.next
        count = count + 1 # account for last elements
        last = current

        # if there is only one element, no need to rotate
        if count == 1:
            return head
        
        # rotating by counts gets us back where we started
        k = k % count 
        if k == 0:
            return head
        
        # attach the last to the first
        last.next = head
        
        
        # get the node at n - k where n is the 
        # create the new end for the list
        current = head
        for i in range(count-k-1):
            current = current.next
        break_point = current 
        new_head = current.next

        break_point.next = None
        return new_head

    

if __name__ == "__main__":
    head = ListNode.createList([1,2,3,4,5])
    head.printList()
    s = Solution()
    head = s.rotateRight(head, 14)
    head.printList()

    head = ListNode.createList([1])
    head.printList()
    s = Solution()
    head = s.rotateRight(head, 1)
    head.printList()
