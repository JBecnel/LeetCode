
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/1486761033/
class ListNthNodeRemove {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        int index = count - n;
        if (index == 0)
            head = head.next;
        else {
            current = head;

            for (int i = 0; i < index - 1; i++)
                current = current.next;

            current.next = current.next.next;

        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode current = head;
        for (int i = 1; i < 10; i++) {
            current.val = i;
            current.next = new ListNode();
            current = current.next;
        }
        current.val = 10;
        ListNthNodeRemove lr = new ListNthNodeRemove();
        head = lr.removeNthFromEnd(head, 10);

        current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}