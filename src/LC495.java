import java.util.ArrayList;

public class LC495 {
    private ArrayList<Integer> list = new ArrayList<>();
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        list.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        list.remove(list.size() - 1);
    }

    /*
     * @return: An integer
     */
    public int top() {
        return list.get((list.size() - 1));
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
