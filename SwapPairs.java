// https://leetcode.com/problems/swap-nodes-in-pairs/description/
public class SwapPairs {
    public static void main(String[] args) {
        ListNode test = ListNode.createList(new int[]{1,2,3,4});
        System.out.println(test);
        SwapPairs sp = new SwapPairs();
        System.out.println(sp.swapPairs(test));

        test = ListNode.createList(new int[]{1,2,3,4,5});
        System.out.println(sp.swapPairs(test));

        test = ListNode.createList(new int[]{1});
        System.out.println(sp.swapPairs(test));

        test = ListNode.createList(new int[]{1,2});
        System.out.println(sp.swapPairs(test));

        test = ListNode.createList(new int[]{});
        System.out.println(sp.swapPairs(test));
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) 
            return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode prev = null; 
        ListNode newHead = second;
        ListNode next = second.next;
        // ... -> prev -> first -> second -> next -> ...
        // ... -> prev -> second -> first -> next -> ...
        while (second != null && first != null) {
            if (prev != null)
                prev.next = second;
            first.next = next;
            second.next = first;
            
            prev = first;
            first = next;
            if (next != null)
                second = next.next;
            if (second != null)
                next = second.next;
        }
        return newHead;
    }
    
}
