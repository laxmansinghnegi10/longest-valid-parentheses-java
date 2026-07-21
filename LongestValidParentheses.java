import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index for calculating valid substring length

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));      // Output: 2
        System.out.println(longestValidParentheses(")()())"));   // Output: 4
        System.out.println(longestValidParentheses(""));         // Output: 0
    }
}