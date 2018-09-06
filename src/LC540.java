import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC540 {
    private Queue<Integer> queue;
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */
    public LC540(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();

        int v1Counter = 0;
        int v2Counter = 0;
        int v1Size = v1.size();
        int v2Size = v2.size();
        int totalSize = v1.size() + v2.size();

        for (int totalCounter = 0; totalCounter < totalSize; totalCounter++) {
            if (v1Counter < v1Size && v2Counter < v2Size) {
                if (totalCounter % 2 == 0) {
                    queue.offer(v1.get(v1Counter));
                    v1Counter++;
                }
                else {
                    queue.offer(v2.get(v2Counter));
                    v2Counter++;
                }
            }
            else if (v1Counter == v1Size && v2Counter < v2Size) {
                queue.offer(v2.get(v2Counter));
                v2Counter++;
            }
            else if (v2Counter == v2Size && v1Counter < v1Size) {
                queue.offer(v1.get(v1Counter));
                v1Counter++;
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
        return queue.poll();
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(11);

        LC540 lc540 = new LC540(list1, list2);
    }
}
