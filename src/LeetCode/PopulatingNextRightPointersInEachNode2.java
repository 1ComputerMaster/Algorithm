package LeetCode;

public class PopulatingNextRightPointersInEachNode2 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode2 p = new PopulatingNextRightPointersInEachNode2();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        p.connect(root);

        // Print the next pointers
        System.out.println(root.left.next.val); // Should print 3
        System.out.println(root.left.left.next.val); // Should print 5
    }
    public Node connect(Node root) {
        if(root == null) return null;
        Node current = root;
        while(current != null){
            Node nextLevelStart = null;
            Node prev = null;
            for(Node node = current; node != null; node = node.next){
                if(node.left != null){
                    if(prev != null){
                        prev.next = node.left;
                    }else{
                        nextLevelStart = node.left;
                    }
                    prev = node.left;
                }
                if(node.right != null){
                    if(prev != null){
                        prev.next = node.right;
                    }else{
                        nextLevelStart = node.right;
                    }
                    prev = node.right;
                }
            }
            current = nextLevelStart;
        }
        return root;
    }
}
