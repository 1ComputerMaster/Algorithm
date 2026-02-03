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
    Map<Node, Node> visitedMap;
    public Node copyRandomList(Node head) {
        visitedMap = new HashMap();
        return dfs(head);
    }
    private Node dfs(Node head){
        if(head == null){
            return null;
        }
        if(visitedMap.containsKey(head)){
            return visitedMap.get(head);
        }
        Node newNode = new Node(head.val);

        visitedMap.put(head, newNode);

        newNode.next = dfs(head.next);
        newNode.random = dfs(head.random);

        return newNode;
    }
}
