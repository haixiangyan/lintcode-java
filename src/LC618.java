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

        set.add(node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            UndirectedGraphNode curNode = queue.poll();
            if (values.get(curNode) == target) {
                return curNode;
            }

            for (int i = 0; i < size; i++) {
                for (UndirectedGraphNode neighbor : curNode.neighbors) {
                    if (!set.contains(neighbor)) {
                        set.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return null;
    }
}
