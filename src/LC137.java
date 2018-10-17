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
            return null;
        }

        // Get old nodes
        List<UndirectedGraphNode> nodes = getNodes(node);

        // Build mapping relation old -> new
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode oldNode : nodes) {
            map.put(oldNode, new UndirectedGraphNode(oldNode.label));
        }

        // Get new neighbors
        for (UndirectedGraphNode oldNode : nodes) {
            UndirectedGraphNode newNode = map.get(oldNode);
            for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return map.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();

            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                    set.add(neighbor);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
