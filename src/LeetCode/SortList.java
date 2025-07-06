package LeetCode;

public class SortList {

    public class ListNode {
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
        ListNode head = new SortList().new ListNode(4);
        head.next = new SortList().new ListNode(2);
        head.next.next = new SortList().new ListNode(1);
        head.next.next.next = new SortList().new ListNode(3);

        SortList sl = new SortList();
        ListNode sortedHead = sl.sortList(head);

        // Print sorted list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Recursive case: sort the rest of the list
        head.next = sortList(head.next);
        // Insert the current node in the sorted list
        return insertInSortedOrder(head, head.next);
    }

    private ListNode insertInSortedOrder(ListNode node, ListNode sortedList) {

        if (sortedList == null || node.val <= sortedList.val) {
            node.next = sortedList;
            return node;
        }

        ListNode current = sortedList;

        while (current.next != null && current.next.val < node.val) {
            current = current.next;
        }

        node.next = current.next;
        current.next = node;

        return sortedList;
    }

}
