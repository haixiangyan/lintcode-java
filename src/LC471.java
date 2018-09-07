import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC471 {
    class Pair {
        public String key;
        public int num;

        public Pair(String key, int num) {
            this.key = key;
            this.num = num;
        }
    }

    private PriorityQueue<Pair> priorityQueue;
    private HashMap<String, Integer> keyToNum;
    private Comparator<Pair> comparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair left, Pair right) {
            if (left.num != right.num) {
                return left.num - right.num;
            }
            return right.key.compareTo(left.key);
        }
    };

    public String[] topKFrequentWords(String[] words, int k) {
        if (k == 0) {
            return new String[0];
        }

        priorityQueue = new PriorityQueue<>(k, comparator);
        keyToNum = new HashMap<>();

        for (String word : words) {
            if (keyToNum.containsKey(word)) {
                keyToNum.put(word, keyToNum.get(word) + 1);
            } else {
                keyToNum.put(word, 1);
            }
        }

        for (String word : keyToNum.keySet()) {
            Pair peekPair = priorityQueue.peek();
            Pair newPair = new Pair(word, keyToNum.get(word));

            if (priorityQueue.size() < k) {
                priorityQueue.add(newPair);
            } else if (comparator.compare(newPair, peekPair) > 0) {
                priorityQueue.poll();
                priorityQueue.add(newPair);
            }
        }

        String[] results = new String[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            results[index++] = priorityQueue.poll().key;
        }

        for (int i = 0; i < index / 2; i++) {
            String temp = results[i];
            results[i] = results[index - i - 1];
            results[index - i - 1] = temp;
        }

        return results;
    }
}
