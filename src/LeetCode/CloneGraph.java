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
    static Map<Node,Node> visitedMap;
    public static Node cloneGraph(Node node) {
        visitedMap = new HashMap();
        return dfs(node);
    }
    private static Node dfs(Node node){
        if(node == null) return null;

        if(visitedMap.containsKey(node)){
            return visitedMap.get(node);
        }
        visitedMap.put(node, new Node(node.val));

        for(Node c : node.neighbors){
            visitedMap.get(node).neighbors.add(dfs(c));
        }
        return visitedMap.get(node);
    }
}
