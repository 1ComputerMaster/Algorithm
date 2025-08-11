package LeetCode;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String path = "/a/./b/../../c/";
        System.out.println(sp.simplifyPath(path)); // Should print "/c"
    }
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.add(part);
            }
        }
        return "/" + String.join("/", stack);
    }

}
