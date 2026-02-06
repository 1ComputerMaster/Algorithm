package LeetCode;

public class SwapNodesInPairs {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        SwapNodesInPairs snp = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode swappedHead = snp.swapPairs(head);
        // Output the swapped list
        ListNode current = swappedHead;
        while (current != null) {
            System.out.print(current.val + " "); // Should print 2 1 4 3
            current = current.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode first = dummy;

        while(head != null && head.next != null){
            dummy.next = new ListNode(head.next.val);
            dummy.next.next = new ListNode(head.val);
            head = head.next.next;
            dummy = dummy.next.next;
        }

        if(head != null){
            dummy.next = new ListNode(head.val);
        }
        return first.next;
    }
}
