package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node head = solution.new Node(1);
        head.next = solution.new Node(2);
        head.random = head.next; // 1's random points to 2
        head.next.random = head; // 2's random points to 1

        Node copiedList = solution.copyRandomList(head);

        // Print copied list
        Node cur = copiedList;
        while (cur != null) {
            System.out.println("Value: " + cur.val + ", Random: " + (cur.random != null ? cur.random.val : "null"));
            cur = cur.next;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        // 1) 노드 복제만
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 2) 노드 붙여넣기
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }

        return map.get(head);
    }
}
