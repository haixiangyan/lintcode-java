import java.util.LinkedList;
import java.util.Queue;

public class LC598 {
    private final int PEOPLE = 0;
    private final int ZOMBIE = 1;
    private final int WALL = 2;

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int people = 0;
        Queue<Point> queue = new LinkedList<>();

        // Init queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == PEOPLE) {
                    people++;
                } else if (grid[i][j] == ZOMBIE) {
                    queue.add(new Point(i, j));
                }
            }
        }

        if (people == 0) {
            return 0;
        }

        // BFS
        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                // Find next point
                for (int direction = 0; direction < 4; direction++) {
                    Point nextPoint = new Point(
                            curPoint.x + dx[direction],
                            curPoint.y + dy[direction]
                    );

                    if (!isInBound(grid, nextPoint)) {
                        continue;
                    }

                    queue.add(nextPoint);
                    grid[nextPoint.x][nextPoint.y] = ZOMBIE;
                    people--;

                    if (people == 0) {
                        return days;
                    }
                }
            }
        }

        return -1;
    }

    private boolean isInBound(int[][] grid, Point nextPoint) {
        if (nextPoint.x < 0 || nextPoint.x >= grid.length) {
            return false;
        }
        if (nextPoint.y < 0 || nextPoint.y >= grid[0].length) {
            return false;
        }

        return grid[nextPoint.x][nextPoint.y] == PEOPLE;
    }
}
