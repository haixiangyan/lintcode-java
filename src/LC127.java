import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        // Record indegree of each node
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        // Initialize queue
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                result.add(node);
                queue.add(node);
            }
        }

        // Sorting
        while (!queue.isEmpty()) {
            // Pop one node
            DirectedGraphNode node = queue.poll();
            // Find the neighbors
            for (DirectedGraphNode neighbor : node.neighbors) {
                // Decrease the indegree
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    result.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }
}
