


class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); 

        int maxLength = 0;

        for (String part : input.split("\n")) {
            int level = part.lastIndexOf("\t") + 1;

            
            while (stack.size() > level + 1) {
                stack.pop();
            }

            int currentLength =
                stack.peek() + part.length() - level + 1;

            stack.push(currentLength);

            
            if (part.contains(".")) {
                maxLength = Math.max(
                    maxLength, currentLength - 1
                );
            }
        }

        return maxLength;
    }
}
