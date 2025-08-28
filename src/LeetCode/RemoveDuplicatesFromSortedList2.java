package LeetCode;

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 r = new RemoveDuplicatesFromSortedList2();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode result = r.deleteDuplicates(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while(current != null && current.next != null){
            if (current.val == current.next.val) {
                while(current.next != null && current.val == current.next.val){
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
