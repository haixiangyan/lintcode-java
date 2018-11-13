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
        if (graph == null) {
            return new ArrayList<>();
        }

        // Prepare indegrees
        Map<DirectedGraphNode, Integer> indegrees = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegrees.put(neighbor, indegrees.getOrDefault(neighbor, 0) + 1);
            }
        }


        Queue<DirectedGraphNode> queue = new LinkedList<>();
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        // Init queue and set
        for (DirectedGraphNode node : graph) {
            if (!indegrees.containsKey(node)) {
                queue.add(node);
                order.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode curNode = queue.poll();

            // Find neighbors
            for (DirectedGraphNode nextNode : curNode.neighbors) {
                indegrees.put(nextNode, indegrees.get(nextNode) - 1);
                if (indegrees.get(nextNode) == 0) {
                    order.add(nextNode);
                    queue.add(nextNode);
                }
            }
        }

        return order;
    }
}
