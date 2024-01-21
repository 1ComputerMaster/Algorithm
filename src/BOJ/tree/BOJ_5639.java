package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5639 {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }
        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public void insert(int val) {
            if(val < this.num){
                if(this.left == null){
                    left = new Node(val);
                }else{
                    left.insert(val);
                }
            }
            else if(val > this.num){
                if(this.right == null){
                    right = new Node(val);
                }else{
                    right.insert(val);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(in.readLine())); //처음 들어오는 수
        String input;
        while (true) {
            try{
                input = in.readLine();
                root.insert(Integer.parseInt(input));
            }catch(Exception e){
                break;
            }
        }
        postOrder(root);
    }

    private static void postOrder(Node root) {
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.num);
        }
    }
}
