public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode createList(int[] vals) {
        if (vals == null || vals.length == 0)
            return null; 
        ListNode head = new ListNode();
        ListNode current = head;
        for (int i = 0; i < vals.length; i++) {
            current.val = vals[i];
            if (i != vals.length-1)
                current.next = new ListNode();
            current = current.next;
        }
        return head; 

    }

    public String toString() {
        String s = "";
        ListNode current = this;
        while (current != null) {
            s = s  + current.val;
            current = current.next; 
            if (current != null)
                s = s + ", ";
        }
        return "["+ s +"]";
       
    }
    public void print() {
        System.out.println(this.toString());
    }
    public static void main(String[] args) {
        System.out.println(" ");
    }

    
}