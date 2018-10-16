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

        int row = grid.length, col = grid[0].length;
        int island = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If it is an island
                if (grid[i][j]) {
                    bfs(grid, i, j);
                    island++;
                }
            }
        }
       return island;
    }

    private void bfs(boolean[][] grid, int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(x, y));
        grid[x][y] = false;

        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            // Get adj node
            for (int i = 0; i < 4; i++) {
                Coordinate adjCoordinate = new Coordinate(
                        coordinate.x + dx[i],
                        coordinate.y + dy[i]
                );
                if (!isBound(grid, adjCoordinate)) {
                    continue;
                }
                if (grid[adjCoordinate.x][adjCoordinate.y]) {
                    grid[adjCoordinate.x][adjCoordinate.y] = false;
                    queue.add(adjCoordinate);
                }
            }
        }
    }
    
    private boolean isBound(boolean[][] grid, Coordinate adjCoordinate) {
        int row = grid.length, col = grid[0].length;
        return (0 <= adjCoordinate.x && adjCoordinate.x <= row - 1) && (0 <= adjCoordinate.y && adjCoordinate.y <= col - 1);
    }
}
