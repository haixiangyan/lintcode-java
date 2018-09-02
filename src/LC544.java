import java.util.Comparator;
import java.util.PriorityQueue;

public class LC544 {
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            priorityQueue.offer(nums[i]);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] results = new int[k];
        while (!priorityQueue.isEmpty()) {
            results[--k] = priorityQueue.poll();
        }

        return results;
    }

    public static void main(String[] args) {
        LC544 lc544 = new LC544();
        lc544.topk(new int[]{3,10,1000,-99,4,100}, 3);
    }
}
