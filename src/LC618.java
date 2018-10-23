import java.util.*;

public class LC618 {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        queue.add(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            if (values.get(curNode) == target) {
                return curNode;
            }

            for (UndirectedGraphNode neighbor : curNode.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                    set.add(neighbor);
                }
            }
        }

        return null;
    }
}
