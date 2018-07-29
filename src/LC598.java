import java.util.LinkedList;
import java.util.Queue;

public class LC598 {
    private final int WALL = 2;
    private final int ZOMBIE = 1;
    private final int PEOPLE = 0;

    class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] detalX = {1, 0, -1, 0};
        int[] detalY = {0, -1, 0, 1};
        int people = 0;

        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == PEOPLE) {
                    people++;
                }
                else if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        int days = 0;

        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate node = queue.poll();

                for (int j = 0; j < 4; j ++) {
                    Coordinate neighbor = new Coordinate(node.x + detalX[j], node.y + detalY[j]);
                    if (isInBound(neighbor, rowLen, colLen) && grid[neighbor.x][neighbor.y] == PEOPLE) {
                        grid[neighbor.x][neighbor.y] = ZOMBIE;
                        people--;
                        if (people == 0) {
                            return days;
                        }

                        queue.offer(neighbor);
                    }
                }
            }
        }

        return -1;
    }

    private boolean isInBound(Coordinate coordinate, int rowLen, int colLen) {
        return (coordinate.x >= 0) && (coordinate.x < rowLen) && (coordinate.y >= 0) && (coordinate.y < colLen);
    }
}
