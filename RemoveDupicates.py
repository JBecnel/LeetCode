'''
https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
'''

import ListNode
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        current = head 
        if current is None or current.next is None:
            return current
        
        while not (current is None):
            val = current.val 
            next_node = current.next
            while (not (next_node is None)) and (val == next_node.val) :
                next_node = next_node.next
            
            current.next = next_node
            current = current.next

        return head 
    
if __name__ == "__main__":
    s = Solution() 
    head = ListNode.createList([1,1,2])
    head = s.deleteDuplicates(head)
    head.printList()

    head = ListNode.createList([1,1,2,3,3])
    head = s.deleteDuplicates(head)
    head.printList()

