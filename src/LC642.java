import java.util.LinkedList;
import java.util.Queue;

public class LC642 {
    private double sum;
    private int size;
    private Queue<Integer> queue;

    /*
    * @param size: An integer
    */
    public LC642(int size) {
        this.size = size;

        queue = new LinkedList<>();
        sum = 0;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        if (queue.size() == size) {
            sum = sum - queue.poll();
        }

        queue.offer(val);
        sum = sum + val;
        return sum / (double) queue.size();
    }
}
