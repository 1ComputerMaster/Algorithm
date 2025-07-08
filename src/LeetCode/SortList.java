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
        if(sortedList == null || node.val <= sortedList.val){
            return node;
        }
        ListNode currentNode = sortedList;

        while (currentNode.next != null && currentNode.next.val < node.val){
            currentNode = currentNode.next;
        }
        node.next = currentNode.next;
        currentNode.next = node;

        return sortedList;
    }

}
