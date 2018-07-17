import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC616 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];

        int orderCounter = 0;
        int[] order = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph construction
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indegrees[prerequisites[i][0]]++;
        }

        // Initialize queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // Topological sorting
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();

            order[orderCounter] = curNode;
            orderCounter++;

            // Check for its adj nodes
            for (Integer adjNode : graph[curNode]) {
                indegrees[adjNode]--;
                if (indegrees[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }

        if (orderCounter != numCourses) {
            return new int[0];
        }

        return order;
    }
}
