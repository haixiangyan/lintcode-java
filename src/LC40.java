import java.util.Stack;

public class LC40 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public LC40() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stack2.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        return stack1.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (stack1.isEmpty()) {
            stack2ToStack1();
        }
        return stack1.peek();
    }
}
