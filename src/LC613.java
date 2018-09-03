import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC613 {
    class Record {
        public int id, score;

        public Record(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    public Map<Integer, Double> highFive(Record[] results) {
        Map<Integer, PriorityQueue<Integer>> cache = new HashMap<>();
        Map<Integer, Double> ans = new HashMap<>();

        for (Record r : results) {
            if (!cache.containsKey(r.id)) {
                cache.put(r.id, new PriorityQueue<>());
            }

            PriorityQueue<Integer> priorityQueue = cache.get(r.id);
            if (priorityQueue.size() < 5) {
                priorityQueue.offer(r.score);
            }
            else {
                if (priorityQueue.peek() < r.score) {
                    priorityQueue.poll();
                    priorityQueue.offer(r.score);
                }
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : cache.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double average = 0;
            while (!scores.isEmpty()) {
                average += scores.poll();
            }

            ans.put(id, average / 5.0);
        }

        return ans;
    }
}
