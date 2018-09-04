import java.util.*;

public class LC545 {
    private PriorityQueue<Integer> priorityQueue;
    private int k;
    private List<Integer> results;
    /*
    * @param k: An integer
    */
    public LC545(int k) {
        this.priorityQueue = new PriorityQueue<>(k);
        this.k = k;
        this.results = new ArrayList<>();
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(num);
        }
        else {
            if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        results.clear();

        // Iterate the priority queue
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            results.add(iterator.next());
        }

        // Sort the array
        results.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        return results;
    }

    public static void main(String[] args) {
        LC545 lc545 = new LC545(3);
        lc545.add(3);
        lc545.add(10);
        lc545.topk();
        lc545.add(1000);
        lc545.add(-99);
        lc545.topk();
        lc545.add(4);
        lc545.topk();
        lc545.add(100);
        lc545.topk();
    }
}
