import java.util.*;

public class LC605 {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        int n = org.length;

        // Init graph
        for (int i = 0; i < org.length; i++) {
            graph.put(org[i], new HashSet<>());
            indegrees.put(org[i], 0);
        }

        // Build graph
        int count = 0;
        for (int[] seq : seqs) {
            count = count + seq.length;
            if (seq.length > 0 && (seq[0] < 0 || seq[0] > n)) {
                return false;
            }

            for (int i = 1; i < seq.length; i++) {
                if (seq[i] < 0 || seq[i] > n) {
                    return false;
                }

                if (graph.get(seq[i - 1]).add(seq[i])) {
                    indegrees.put(seq[i], indegrees.get(seq[i]) + 1);
                }
            }
        }

        if (count < n) {
            return false;
        }

        // Init queue
        Queue<Integer> queue = new LinkedList<>();
        for (Integer num : indegrees.keySet()) {
            if (indegrees.get(num) == 0) {
                queue.add(num);
            }
        }

        // Top sort
        int index = 0;
        int[] order = new int[n];
        while (queue.size() == 1) {
            Integer curNum = queue.poll();

            order[index] = curNum;
            if (org[index] != order[index]) {
                return false;
            }

            // Find next num
            for (Integer nextNum : graph.get(curNum)) {
                // Subtract indegree
                indegrees.put(nextNum, indegrees.get(nextNum) - 1);
                if (indegrees.get(nextNum) == 0) {
                    queue.add(nextNum);
                }
            }

            index = index + 1;
        }

        if (index != n) {
            return false;
        }
        else {
            return true;
        }
    }
}
