package LeetCode;

public class MergeTwoSortedLists {
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
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = m.mergeTwoLists(list1, list2);

        // Print merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 한쪽이 비었으면 다른 한쪽을 그대로 리턴
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 더 작은 값의 노드를 고르고, 그 다음 노드에 재귀 호출 결과를 붙인다
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}
