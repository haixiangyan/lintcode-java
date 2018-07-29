import java.util.*;

public class LC531 {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (s == t) {
            return 0;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(s);
        set.add(s);

        int steps = 0;

        while (!queue.isEmpty()) {
            steps ++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curNode = queue.poll();
                for (UndirectedGraphNode adjNode : curNode.neighbors) {
                    if (!set.contains(adjNode)) {
                        if (adjNode == t) {
                            return steps;
                        }
                        queue.offer(adjNode);
                        set.add(adjNode);
                    }
                }
            }
        }

        return -1;
    }
}
