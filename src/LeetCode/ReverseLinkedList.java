package LeetCode;

public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode head = r.new ListNode(1, r.new ListNode(2, r.new ListNode(3, r.new ListNode(4))));
        ListNode reversedHead = r.reverseList(head);
        // Print the reversed list
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode node = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }

        return node;
    }
}
