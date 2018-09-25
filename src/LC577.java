import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC577 {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class Pair {
        int row, col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        int k = intervals.size();
        PriorityQueue<Pair> pairsQueue = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return intervals.get(p1.row).get(p1.col).start - intervals.get(p2.row).get(p2.col).start;
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).size() > 0) {
                pairsQueue.add(new Pair(i, 0));
            }
        }

        List<Interval> results = new ArrayList<>();
        while (!pairsQueue.isEmpty()) {
            Pair pair = pairsQueue.poll();
            results.add(intervals.get(pair.row).get(pair.col));
            pair.col++;
            if (pair.col < intervals.get(pair.row).size()) {
                pairsQueue.add(pair);
            }
        }

        return merge(results);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> results = new ArrayList<>();
        Interval last = intervals.get(0);

        for (Interval curtInterval : intervals) {
            if (last.end < curtInterval.start) {
                results.add(last);
                last = curtInterval;
            }
            else {
                last.end = Math.max(last.end, curtInterval.end);
            }
        }

        if (last != null) {
            results.add(last);
        }
        return results;
    }
}
