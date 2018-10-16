import java.util.LinkedList;
import java.util.Queue;

public class LC611 {
    static class Point { int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    private int row;
    private int col;

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        row = grid.length;
        col = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.add(source);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                if (curPoint.x == destination.x && curPoint.y == destination.y) {
                    return steps;
                }
                // Find its next step
                for (int j = 0; j < 8; j++) {
                    Point nextPoint = new Point(
                            curPoint.x + dx[j],
                            curPoint.y + dy[j]
                    );
                    if (!isBound(grid, nextPoint)) {
                        continue;
                    }

                    queue.add(nextPoint);
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            // 加入了当前的层之后才能算是走了一步
            steps++;
        }

        return -1;
    }

    private boolean isBound(boolean[][] grid, Point nextPoint) {
        if (0 > nextPoint.x || nextPoint.x >= row) {
            return false;
        }
        if (0 > nextPoint.y || nextPoint.y >= col) {
            return false;
        }
        return !grid[nextPoint.x][nextPoint.y];
    }
}
