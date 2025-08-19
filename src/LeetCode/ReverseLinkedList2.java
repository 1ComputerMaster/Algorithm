package LeetCode;

public class ReverseLinkedList2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ReverseLinkedList2 solution = new ReverseLinkedList2();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int left = 2;
        int right = 4;
        ListNode result = solution.reverseBetween(head, left, right);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 0;
        // 1) 더미노드로 head 변경 대비
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2) prev를 left-1 위치로 이동
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) prev = prev.next;

        ListNode cur = prev.next;
        for(int i = 0; i < right - left; i++){
            ListNode move = cur.next;
            cur.next = move.next;
            move.next = prev.next;
            prev.next = move;

        }
        return dummy.next;
    }
}
