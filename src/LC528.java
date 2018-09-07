import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LC528 implements Iterator<Integer> {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private Stack<NestedInteger> stack;

    public LC528(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushToStack(nestedList);
    }

    private void pushToStack(List<NestedInteger> nestedList) {
        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger nestedInteger : nestedList) {
            temp.push(nestedInteger);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushToStack(stack.pop().getList());
        }

        return !stack.isEmpty();
    }

    @Override
    public void remove() {
    }
}
