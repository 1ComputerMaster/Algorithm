package LeetCode;

import java.util.*;

public class CloneGraph {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static void main(String[] args) {
        // Example usage
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedGraph = cloneGraph(node1);
        System.out.println("Cloned graph created with root value: " + clonedGraph.val);
    }
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // 1) 원본 노드 → 복제 노드 매핑
        Map<Node, Node> cloneMap = new HashMap<>();
        // 2) BFS용 큐
        Queue<Node> q = new LinkedList<>();

        // 시작 노드 복제 및 준비
        cloneMap.put(node, new Node(node.val, new ArrayList<>()));
        q.add(node);

        // 3) BFS 순회
        while (!q.isEmpty()) {
            Node cur = q.poll();
            Node curClone = cloneMap.get(cur);

            // 이웃 처리
            for (Node nei : cur.neighbors) {
                // 아직 복제본이 없으면 새로 생성하고 큐에 추가
                if (!cloneMap.containsKey(nei)) {
                    cloneMap.put(nei, new Node(nei.val, new ArrayList<>()));
                    q.add(nei);
                }
                // 복제본의 이웃 리스트에, 반드시 복제본을 추가
                curClone.neighbors.add(cloneMap.get(nei));
            }
        }

        // 첫 노드의 복제본 반환
        return cloneMap.get(node);
    }

}
