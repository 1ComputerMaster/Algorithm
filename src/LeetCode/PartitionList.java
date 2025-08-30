package LeetCode;

public class PartitionList {
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

        // Example usage
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        int x = 3;

        PartitionList solution = new PartitionList();
        ListNode result = solution.partition(head, x);

        // Print the resulting linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallTail = new ListNode(0);
        ListNode bigTail = new ListNode(0);
        ListNode current = head;
        ListNode bigHead = bigTail;
        ListNode smallHead = smallTail;
        while(current != null){
            if(current.val >= x){
                bigTail.next = new ListNode(current.val);
                bigTail = bigTail.next;
            }else{
                smallTail.next = new ListNode(current.val);
                smallTail = smallTail.next;
            }
            current = current.next;
        }
        if(bigHead.next != null)
            smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
