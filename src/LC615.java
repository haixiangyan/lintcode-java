import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC615 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];

        // Init nodes
        ArrayList[] nodes = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new ArrayList<>();
        }

        // Build graph
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
            nodes[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            count++;

            // Sub 1 for this children
            for (int i = 0; i < nodes[curCourse].size(); i++) {
                int nextCourse = (int) nodes[curCourse].get(i);
                indegrees[nextCourse]--;
                if (indegrees[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        return count == numCourses;
    }
}
