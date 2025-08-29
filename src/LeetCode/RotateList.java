package LeetCode;

public class RotateList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        RotateList r = new RotateList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = r.rotateRight(head, k);
        r.printList(result);
    }

    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1) 길이와 꼬리
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) { tail = tail.next; n++; }

        // 2) k 축소
        k %= n;
        if (k == 0) return head;

        // 3) 원형으로 만들기
        tail.next = head;

        // 4) 새 꼬리: head에서 n-k-1칸 이동
        int stepsToNewTail = n - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) newTail = newTail.next;

        // 5) 새 head 및 끊기
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
