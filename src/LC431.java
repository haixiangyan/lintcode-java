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
        List<List<Integer>> connectedGraphs = new ArrayList<>();

        if (nodes == null || nodes.size() == 0) {
            return connectedGraphs;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        while (nodes.size() != 0) {
            queue.offer(nodes.get(0));
            set.add(nodes.get(0));

            List<Integer> connectedGraph = new ArrayList<>();

            while (!queue.isEmpty()) {
                UndirectedGraphNode curNode = queue.poll();
                connectedGraph.add(curNode.label);

                for (UndirectedGraphNode adjNode : curNode.neighbors) {
                    if (!set.contains(adjNode)) {
                        queue.offer(adjNode);
                        set.add(adjNode);
                    }
                }

                nodes.remove(curNode);
            }

            connectedGraph.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            connectedGraphs.add(connectedGraph);
        }

        return connectedGraphs;
    }
}