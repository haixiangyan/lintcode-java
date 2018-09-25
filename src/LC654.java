import java.util.ArrayList;
import java.util.List;

public class LC654 {
    class Point {
        int x, y, val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int[][] multiply(int[][] A, int[][] B) {
        List<Point> pointA = new ArrayList<>();
        List<Point> pointB = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    pointA.add(new Point(i, j, A[i][j]));
                }
            }
        }

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (B[i][j] != 0) {
                    pointB.add(new Point(i, j, B[i][j]));
                }
            }
        }

        List<Point> results = new ArrayList<>();
        for (Point a : pointA) {
            for (Point b : pointB) {
                if (a.y == b.x) {
                    results.add(new Point(a.x, b.y, a.val * b.val));
                }
            }
        }

        int[][] C = new int[A.length][B[0].length];
        for (Point point : results) {
            C[point.x][point.y] += point.val;
        }

        return C;
    }
}
