import java.util.*;

public class LC127 {
    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // Get all nodes' indegreees
        Map<DirectedGraphNode, Integer> indegrees = getIndegrees(graph);

        // Init results list
        ArrayList<DirectedGraphNode> results = new ArrayList<>();

        // Init queue
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        initQueue(graph, indegrees, queue, results);

        // sorting
        startSorting(queue, indegrees, results);

        return results;
    }

    private Map<DirectedGraphNode, Integer> getIndegrees(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegrees = new HashMap<>();

        for (DirectedGraphNode node : graph) {
            // Find neighbor
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegrees.put(neighbor, indegrees.getOrDefault(neighbor,0) + 1);
            }
        }

        return indegrees;
    }

    private void initQueue(
            ArrayList<DirectedGraphNode> graph,
            Map<DirectedGraphNode, Integer> indegrees,
            Queue<DirectedGraphNode> queue,
            List<DirectedGraphNode> results)  {
        for (DirectedGraphNode node : graph) {
            if (!indegrees.containsKey(node)) {
                queue.add(node);
                results.add(node);
            }
        }
    }

    private void startSorting(Queue<DirectedGraphNode> queue, Map<DirectedGraphNode, Integer> indegrees, List<DirectedGraphNode> results) {
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode n : node.neighbors) {
                indegrees.put(n, indegrees.get(n) - 1);
                if (indegrees.get(n) == 0) {
                    results.add(n);
                    queue.add(n);
                }
            }
        }
    }
}
