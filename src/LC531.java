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

        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        set.add(s);
        queue.add(s);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curNode = queue.poll();
                if (curNode == t) {
                    return steps;
                }

                for (UndirectedGraphNode nextNode : curNode.neighbors) {
                    if (!set.contains(nextNode)) {
                        queue.add(nextNode);
                        set.add(nextNode);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
