# https://leetcode.com/problems/partition-list/description/
'''
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:

Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]
Example 2:

Input: head = [2,1], x = 2
Output: [1,2]
 

Constraints:

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
'''
import ListNode


class Solution:
    def partition(self, head: ListNode, x: int):
        if head is None:
            return head 
        
        big = None  # start of list with bigger number >= x
        lil = None  # start of list with smaller nubmers < x
        curB = None # current element of bigger list
        curL = None # current element of list with smaller nubmers

        current = head 
        while not (current is None):
            if current.val < x:
                if lil is None:  # insert first element in smaller list
                    lil = current
                    curL = current
                else:  # add to smaller list
                    curL.next = current
                    curL = curL.next
            else:
                if big is None: # insert first element in bigger list
                    big = current
                    curB = current
                else:  # add to bigger list
                    curB.next = current
                    curB = curB.next
            
            current = current.next  # go to next element
           
        if curL is None:
            return head 
        else:
            curL.next = big # connect the two list
            if not (curB is None): # set the end of list
                curB.next = None 
        
        return lil 
        

if __name__ == "__main__":
    s = Solution()
    s.partition(ListNode.createList([1,4,3,2,5,2]), 3).printList()
    s.partition(ListNode.createList([2,1]), 2).printList()
    s.partition(ListNode.createList([2,1]), 3).printList()
    s.partition(ListNode.createList([2,1]), 1).printList()
    s.partition(ListNode.createList([2]), 1).printList()
    s.partition(ListNode.createList([2]), 3).printList()