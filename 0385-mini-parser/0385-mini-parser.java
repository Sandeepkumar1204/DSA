
import java.util.*;

class Solution {
    public NestedInteger deserialize(String s) {
        // If the input is a single integer
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger current = null;
        int num = 0;
        int sign = 1;
        boolean readingNumber = false;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                NestedInteger list = new NestedInteger();

                if (!stack.isEmpty()) {
                    stack.peek().add(list);
                }

                stack.push(list);
            } else if (c == '-' || Character.isDigit(c)) {
                if (!readingNumber) {
                    num = 0;
                    sign = 1;
                    readingNumber = true;
                }

                if (c == '-') {
                    sign = -1;
                } else {
                    num = num * 10 + (c - '0');
                }
            } else if (c == ',' || c == ']') {
                if (readingNumber) {
                    stack.peek().add(
                        new NestedInteger(sign * num)
                    );
                    readingNumber = false;
                }

                if (c == ']') {
                    current = stack.pop();
                }
            }
        }

        return current;
    }
}
