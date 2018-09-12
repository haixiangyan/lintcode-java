import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC156 {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalComparator());

        List<Interval> ans = new ArrayList<>();
        Interval last = intervals.get(0);

        for (Interval curt : intervals) {
            if (last.end >= curt.start) {
                last.end = Math.max(last.end, curt.end);
            }
            else {
                ans.add(last);
                last = curt;
            }
        }

        ans.add(last);
        return ans;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
