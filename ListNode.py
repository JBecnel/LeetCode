def createList(nums : list[int]):
    node = ListNode(nums[0])
    head = node 
    for i in range(1, len(nums)):
        nextnode = ListNode(nums[i])
        node.next = nextnode
        node = nextnode

    return head

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

   
