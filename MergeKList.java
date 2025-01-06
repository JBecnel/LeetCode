// merge k list

import java.util.HashSet;

public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] nodes = new ListNode[lists.length];
        HashSet<Integer> indices = new HashSet<Integer>();

        for (int i = 0; i < lists.length; i++) {
            nodes[i] = lists[i];
            if (lists[i] != null)
                indices.add(i);
        }

        // if all lists are null
        if (indices.isEmpty())
            return null;

        // if only one list is not null return that list
        if (indices.size() == 1)
            return lists[indices.iterator().next()];

        
        ListNode merged = new ListNode();
        ListNode current = merged;
        while (indices.size() > 1) {
            // find min indices
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (Integer i : indices) {
                if (nodes[i].val < min) {
                    min = nodes[i].val; 
                    index = i;
                }
            }
            current.val = nodes[index].val;
            nodes[index] = nodes[index].next;

            if (nodes[index] == null)
                indices.remove(index);
            // create a new node at the end of the list
            // to update on the next iteration
            if (indices.size() > 1){
              ListNode next = new ListNode();
              current.next = next;
              current = next; 
            }
        }   
        // when we exit the loop only one list has element insit

        // if both are at the end
        current.next = nodes[indices.iterator().next()];
        return merged;
    } 
}

