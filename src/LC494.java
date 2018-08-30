import java.util.LinkedList;
import java.util.Queue;

public class LC494 {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private Queue<Integer> exchange;
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        int size = queue1.size();
        // Push elements from queue1 to queue2
        for (int i = 1; i < size; i++) {
            queue2.offer(queue1.poll());
        }
        // Remove the last element
        queue1.poll();
        // Exchange queue1 and queue2
        exchange = queue1;
        queue1 = queue2;
        queue2 = exchange;
    }

    /*
     * @return: An integer
     */
    public int top() {
        int size = queue1.size();
        // Push elements from queue1 to queue2
        for (int i = 1; i < size; i++) {
            queue2.offer(queue1.poll());
        }
        Integer topEl = queue1.poll();
        queue2.offer(topEl);

        // Exchange queue1 and queue2
        exchange = queue1;
        queue1 = queue2;
        queue2 = exchange;
        return topEl;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return queue1.size() == 0;
    }

    public static void main(String[] args) {
        LC494 lc494 = new LC494();
        lc494.push(1);
        lc494.push(2);
        lc494.push(3);

        lc494.top();
    }
}
