import java.util.*;

public class LC178 {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }
        // Has cycles?
        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        queue.add(0);
        set.add(0);

        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();

            for (Integer nextNode : graph.get(curNode)) {
                if (!set.contains(nextNode)) {
                    queue.add(nextNode);
                    set.add(nextNode);
                }
            }
        }

        return set.size() == n;
    }

    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
