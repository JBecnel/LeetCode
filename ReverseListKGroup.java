/*
https://leetcode.com/problems/reverse-nodes-in-k-group/
Follow-up: Can you solve the problem in O(1) extra memory space?
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
*/ 

public class ReverseListKGroup {

    //=======================MAIN=======================
    /* This method is used for testing. A list is constructed from the
    array and the reverseKGroup method is called.
    The output is printed.
    */
    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5, 6 };
        ListNode node = new ListNode(vals[0]);
        ListNode head = node;
        for (int i = 1; i < vals.length; i++) {
            node.next = new ListNode(vals[i]);
            node = node.next;
        }
        reverseKGroup(head, 6);
        printList(head);
    }


    //-------------------reverseKGroup----------------------
    /* This method takes the head of a list and reverses consecutive
    groups of k.
    Pre : given the head of the list and the size of the group to reverse
    Post: the groups of k are reversed
    */
    public static void reverseKGroup(ListNode head, int k) {
        // get teh kth element in the list (could be null)
        ListNode kthElement = getKthElement(k, head);
        int j = k; // j is used so we do not lose the value of k
        ListNode node = head; // node is used so we do not lose the value of head
        ListNode swapElement = kthElement; // used so we do not lose value of kthElement
        
        if (kthElement != null) {  // if the list does not have k elements, then nothing to do
            // when j = 1 (or o) we have met in the middle of the list
            while (j >= 1) {
                System.out.println(node.val + " " + swapElement.val + " " + j);
                swap(node, swapElement); // swap the values 
                j = j - 2;    // ignore first and kth element of list (swapped above)
                node = node.next;  // go to next element
                swapElement = getKthElement(j, node); // find element to swap it with
            }
            if (kthElement.next != null)  // if elements in the list remain, continue swapping
                reverseKGroup(kthElement.next, k);
        }   
              
    }

    /*---------------------getKthElement-----------------------
    This method finds the kth element of the list. If the list does not contain k
    elements, then null is returned.
    Pre : given a positive integer k representing the position of the element desired
    and the head of the list
    Post: the kth element of the list is returned; null is returned if there is no kth element
    */
    public static ListNode getKthElement(int k, ListNode head) {
        ListNode node = head;
        k = k - 1;
        // traverse node by node until we find the
        // kth element element is found or
        // determined that the kth element does not exist
        while (node != null && k != 0) {
            k = k - 1;
            node = node.next;
        }

        return node;
    }

    //-----------------------swap----------------------
    /* This simply swaps the values fo two nodes in a list.
    Pre : the nodes exists (not null)
    Post: the integer values are swapped.
    */
    public static void swap(ListNode a, ListNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    //--------------------printList-------------------
    /* This method prints out the values in the list.
    Pre : given the head of the list.
    Post: the values are printed to the console.
    */
    public static void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
} // end class