import java.util.LinkedList;
import java.util.Queue;

public class LC611 {
    static class Point {
        int x;
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

    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        int[] directionX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] directionY = {2, -2, 2, -2, 1, -1, 1, -1};
        Queue<Point> queue = new LinkedList<>();

        int steps = 0;

        queue.offer(source);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                if (curPoint.x == destination.x && curPoint.y == destination.y) {
                    return steps;
                }

                for (int j = 0; j < 8; j++) {
                    Point point = new Point(
                            curPoint.x + directionX[j],
                            curPoint.y + directionY[j]
                    );

                    // Skip invalid point
                    if (!isInBound(grid, point)) {
                        continue;
                    }

                    queue.offer(point);
                    grid[point.x][point.y] = true;
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isInBound(boolean[][] grid, Point point) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        if (point.x < 0 || point.x >= maxRow) {
            return false;
        }
        if (point.y < 0 || point.y >= maxCol) {
            return false;
        }

        return !grid[point.x][point.y];
    }

    public static void main(String[] args) {
        Point source = new Point(2, 0);
        Point destination = new Point(2, 2);

        boolean[][] grid = {
                {false, true, false},
                {false, false, false},
                {false, false, false}
        };

        LC611 lc611 = new LC611();

        System.out.println(lc611.shortestPath(grid, source, destination));
    }
}
