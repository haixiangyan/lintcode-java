import java.util.PriorityQueue;

public class LC606 {
    public int kthLargestElement2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            }
            else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        LC606 lc606 = new LC606();

        System.out.println(lc606.kthLargestElement2(new int[]{9,3,2,4,8}, 3));
    }
}
