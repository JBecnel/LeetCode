public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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