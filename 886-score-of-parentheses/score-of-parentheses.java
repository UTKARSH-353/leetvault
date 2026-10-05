import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(0);
            } else {

                int value = stack.pop();

                if (value == 0) {
                    value = 1;
                } else {
                    value = 2 * value;
                }

                int top = stack.pop();
                stack.push(top + value);
            }
        }

        return stack.pop();
    }
}