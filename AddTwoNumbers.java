public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] l1 = new int[]{9, 9, 9, 9, 9, 9};
        int[] l2 = new int[]{9,9,9,9};
        int[] l3 = new int[]{2,4,3};
        int[] l4 = new int[]{5,6,4};
        addTwoNumbers(convertToList(l1), convertToList(l2)).print();
        addTwoNumbers(convertToList(l3),convertToList(l4)).print();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int d1 = 0; int d2 = 0;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null || carry > 0) {
            result.next = new ListNode();
            result = result.next; 
            d1 = 0; d2 = 0;
            if (l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            }
            sum = d1 + d2 + carry;
            carry = sum / 10; 
            result.val = sum % 10;
        }
        return head.next;
    }

    public static ListNode convertToList(int[] array) {
        ListNode head = new ListNode();
        head.val = array[0];
        ListNode prev = head;
        for (int i = 1; i < array.length; i++) {
            prev.next = new ListNode(array[i]);
            prev = prev.next;
        }
        return head;
    }

    
}
