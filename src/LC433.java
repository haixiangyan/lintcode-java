import java.util.LinkedList;
import java.util.Queue;

public class LC433 {
    class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    markByBFS(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void markByBFS(boolean[][] grid, int x, int y) {
        int[] directionX = {1, 0, -1, 0};
        int[] directionY = {0, 1, 0, -1};
        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(x, y));
        grid[x][y] = false;

        while (!queue.isEmpty()) {
            Coordinate curNode = queue.poll();

            // Search for 4 adj nodes
            for (int i = 0; i < 4; i++) {
                Coordinate adjNode = new Coordinate(
                        curNode.x + directionX[i],
                        curNode.y + directionY[i]
                );

                // Skip invalid adj node
                if (!inBound(grid, adjNode)) {
                    continue;
                }

                if (grid[adjNode.x][adjNode.y]) {
                    grid[adjNode.x][adjNode.y] = false;
                    queue.offer(adjNode);
                }
            }
        }
    }

    private boolean inBound(boolean[][] grid, Coordinate node) {
        int n = grid.length;
        int m = grid[0].length;

        return (node.x >= 0) && (node.x < n) && (node.y >= 0) && (node.y < m);
    }
}
