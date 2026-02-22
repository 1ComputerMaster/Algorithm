package LeetCode;

public class IntersactionOfTwoListNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        IntersactionOfTwoListNode intersactionOfTwoListNode = new IntersactionOfTwoListNode();
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);
        headA.next.next = intersect;
        headB.next.next.next = intersect;

        ListNode result = intersactionOfTwoListNode.getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val); // Should print
        } else {
            System.out.println("No intersection.");
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        while (lenA > lenB) { headA = headA.next; lenA--; }
        while (lenB > lenA) { headB = headB.next; lenB--; }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) { len++; node = node.next; }
        return len;
    }
}
