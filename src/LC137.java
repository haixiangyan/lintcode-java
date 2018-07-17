import java.util.*;

public class LC137 {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // Get all nodes
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        // Copy nodes
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode curNode : nodes) {
            mapping.put(curNode, new UndirectedGraphNode(curNode.label));
        }

        // Copy edges (Neighbors)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode startNode) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(startNode);
        set.add(startNode);

        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();

            for (UndirectedGraphNode adjNode : node.neighbors) {
                if (!set.contains(adjNode)) {
                    queue.offer(adjNode);
                    set.add(adjNode);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
