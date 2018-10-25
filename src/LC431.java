import java.util.*;

public class LC431 {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>();

        // Init visited
        for (UndirectedGraphNode node : nodes) {
            visited.put(node, false);
        }

        // Iterate each node
        for (UndirectedGraphNode node : nodes) {
            if (!visited.get(node)) {
                bfs(node, visited, results);
            }
        }

        return results;
    }

    private void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> results) {
        List<Integer> connectedGraph = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            visited.put(curNode, true);
            connectedGraph.add(curNode.label);

            for (UndirectedGraphNode nextNode : curNode.neighbors) {
                if (!visited.get(nextNode)) {
                    queue.add(nextNode);
                    visited.put(nextNode, true);
                }
            }
        }

        Collections.sort(connectedGraph);
        results.add(connectedGraph);
    }
}