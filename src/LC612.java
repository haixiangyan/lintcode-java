import java.util.Comparator;
import java.util.PriorityQueue;

public class LC612 {
    class Point {
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

    private Point originalPoint;

    public Point[] kClosest(Point[] points, Point origin, int k) {
        Point[] results = new Point[k];

        originalPoint = origin;

        PriorityQueue<Point> pQueue = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point pointA, Point pointB) {
                int diff = getDistance(pointB, originalPoint) - getDistance(pointA, originalPoint);
                if (diff == 0) {
                    diff = pointB.x - pointA.x;
                }
                if (diff == 0) {
                    diff = pointB.y - pointA.y;
                }
                return diff;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pQueue.offer(points[i]);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
        }

        k = pQueue.size();
        while (!pQueue.isEmpty()) {
            results[--k] = pQueue.poll();
        }
        return results;
    }

    private int getDistance(Point pointA, Point pointB) {
        return (pointA.x - pointB.x) * (pointA.x - pointB.x) + (pointA.y - pointB.y) * (pointA.y - pointB.y);
    }
}
