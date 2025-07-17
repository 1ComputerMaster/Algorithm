package LeetCode;

public class RemoveDuplicatesfromSortedList {
    public static class ListNode {
            int val;
            ListNode next;
            ListNode() {
            }
            ListNode(int val) {
                this.val = val;
            }
            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
    }
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList r = new RemoveDuplicatesfromSortedList();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode result = r.deleteDuplicates(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            return head.next;
        }

        return head;
    }
}
