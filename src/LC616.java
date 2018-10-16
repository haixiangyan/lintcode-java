import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC616 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            order[index++] = curCourse;

            // Find courses that it points to
            for (int i = 0; i < graph[curCourse].size(); i++) {

                int nextCourse = (int) graph[curCourse].get(i);
                indegrees[nextCourse]--;
                if (indegrees[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        if (index == numCourses) {
            return order;
        }
        return new int[0];
    }
}
