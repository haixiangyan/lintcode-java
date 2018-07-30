import java.util.*;

public class LC178 {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, HashSet<Integer>> graph = createGraph(n, edges);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.offer(0);
        set.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer adjNode : graph.get(node)) {
                if (!set.contains(adjNode)) {
                    queue.offer(adjNode);
                    set.add(adjNode);
                }
            }
        }

        return (set.size() == n);
    }

    private Map<Integer, HashSet<Integer>> createGraph(int n, int[][] edges) {
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();

        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        // Construct graph
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        return graph;
    }
}
