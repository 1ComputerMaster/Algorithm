package LeetCode;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = d.dailyTemperatures(temperatures);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int top = stack.pop();
                answer[top] = i - top;
            }
            stack.add(i);
        }
        return answer;
    }
}
