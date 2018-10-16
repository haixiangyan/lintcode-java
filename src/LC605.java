import java.util.*;

public class LC605 {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();

        // Init graph
        initGraph(org, graph, indegrees);

        // Build graph
        int n = org.length;
        int seqLength = buildGraph(n, seqs, graph, indegrees);
        if (seqLength == -1) {
            return false;
        }

        // Check edge case
        if (seqLength < n) {
            return false;
        }

        // Topological sorting
        int count = topSort(org, graph, indegrees);

        return count == org.length;
    }

    private void initGraph(int[] org, Map<Integer, Set<Integer>> graph, Map<Integer, Integer> indegrees) {
        for (int num : org) {
            graph.put(num, new HashSet<>());
            indegrees.put(num, 0);
        }
    }

    private int buildGraph(
            int n,
            int[][] seqs,
            Map<Integer, Set<Integer>> graph,
            Map<Integer, Integer> indegrees
    ) {
        int count = 0;
        for (int[] seq : seqs) {
            count = count + seq.length;
            // Check the first element whether is invalid
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) {
                return -1;
            }
            for (int i = 1; i < seq.length; i++) {
                // Check if each element is valid
                if (seq[i] <= 0 || seq[i] > n) {
                    return -1;
                }
                if (graph.get(seq[i - 1]).add(seq[i])) {
                    indegrees.put(seq[i], indegrees.get(seq[i]) + 1);
                }
            }
        }
        return count;
    }

    private int topSort(
            int[] org,
            Map<Integer, Set<Integer>> graph,
            Map<Integer, Integer> indegrees
    ) {
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (Integer num : indegrees.keySet()) {
            if (indegrees.get(num) == 0) {
                queue.add(num);
            }
        }

        while (queue.size() == 1) {
            int curNum = queue.poll();

            // Find its neighbors and sub - 1 for their indegrees
            for (int nextNum : graph.get(curNum)) {
                indegrees.put(nextNum, indegrees.get(nextNum) - 1);
                if (indegrees.get(nextNum) == 0) {
                    queue.add(nextNum);
                }
            }

            // Check if curNum suit org sequence
            if (curNum != org[index]) {
                return -1;
            }
            index++;
        }

        return index;
    }
}
