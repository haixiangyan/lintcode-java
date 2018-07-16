import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC615 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] nodes = new List[numCourses];
        int[] indegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            nodes[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        // Topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int courses = 0;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            courses++;

            for (Integer i : nodes[node]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return courses == numCourses;
    }
}
