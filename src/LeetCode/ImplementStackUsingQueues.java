package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.empty()); // return False
    }

    static class MyStack {

        private Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        public void push(int x) {
            q.add(x);
            for (int i = 0; i < q.size() - 1; i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
