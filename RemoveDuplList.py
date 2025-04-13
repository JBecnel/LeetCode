'''
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]'''
import ListNode
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # single node or empty list
        if head is None or head.next is None:
            return head
        else:
            # check if the first node is a duplicate
            if head.val == head.next.val:
                # find the first non-duplicate node
                current = head.next
                while current is not None and current.val == head.val:
                    current = current.next
                return self.deleteDuplicates(current)
            else:
                # check for duplicates in the rest of the list
                head.next = self.deleteDuplicates(head.next)
                return head
        
        
if __name__ == "__main__":
    nums = [1,2,3,3,4,4,5]
    head = ListNode.createList(nums)
    head = Solution().deleteDuplicates(head)
    head.printList()
    
    nums = [1,1,1,2,3]
    head = ListNode.createList(nums)    
    head = Solution().deleteDuplicates(head)
    head.printList()
    
    nums =[i for i in range(1,11)]
    head = ListNode.createList(nums)
    head = Solution().deleteDuplicates(head)
    head.printList()
    
    nums = [1,1,1,1,1,1,1,1]
    head = ListNode.createList(nums)
    head = Solution().deleteDuplicates(head)
    print(head)