package LeetCode;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();
        ListNode head = p.new ListNode(1);
        head.next = p.new ListNode(2);
        head.next.next = p.new ListNode(3);
        head.next.next.next = p.new ListNode(2);
        head.next.next.next.next = p.new ListNode(1);
        System.out.println(p.isPalindrome(head));
    }

    private static ListNode reverse(ListNode slow) {
        ListNode prev = null, curr = slow, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        while (rev != null) {
            if (rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    class ListNode {
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
}
