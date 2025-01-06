//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class MergeList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        if (list1 == null && list2 == null)
            return null;
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode merged = new ListNode();
        ListNode current = merged;
        while (node1 != null && node2 != null) {
            // insert value and move along in the list
            if (node1.val <= node2.val) {
                current.val = node1.val;
                node1 = node1.next;
            } else {
                current.val = node2.val;
                node2 = node2.next;
            }
            // create a new node at the end of the list
            // to update on the next iteration
            if (node1 != null && node2 != null){
              ListNode next = new ListNode();
              current.next = next;
              current = next; 
            }
        }   
        // when we exit the loop either list1 or list2 has
        // made it to the end

        // if both are at the end
        if (node1 == null && node2 == null)
            current.next = null;
        else if (node1 == null) 
            current.next = node2;
        else if (node2 == null)
            current.next = node1;
        return merged;
    } 
}
