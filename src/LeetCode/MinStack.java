package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());    // Returns 0.
        System.out.println(minStack.getMin()); // Returns -2.
    }
    private List<int[]> list;

    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        int[] top = list.isEmpty() ? new int[]{val, val} : list.get(list.size() - 1);
        int min_val = top[1];
        if (min_val > val) {
            min_val = val;
        }
        list.add(new int[]{val, min_val});
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1)[0];

    }

    public int getMin() {
        return list.get(list.size() - 1)[1];
    }
}
