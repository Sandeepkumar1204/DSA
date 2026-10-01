import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();

        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        hasNext();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty()) {

            NestedInteger current = stack.peek();

            if (current.isInteger()) {
                return true;
            }

            stack.pop();

            List<NestedInteger> list = current.getList();

            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }

        return false;
    }
}