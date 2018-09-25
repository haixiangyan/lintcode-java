import java.util.ArrayList;
import java.util.List;

public class LC839 {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> results = new ArrayList<>();
        if (list1 == null || list2 == null) {
            return results;
        }

        Interval last = null, curt = null;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                curt = list1.get(i);
                i++;
            }
            else {
                curt = list2.get(j);
                j++;
            }

            last = merge(results, last, curt);
        }

        while (i < list1.size()) {
            last = merge(results, last, list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            last = merge(results, last, list2.get(j));
            j++;
        }

        if (last != null) {
            results.add(last);
        }

        return results;
    }

    public Interval merge(List<Interval> results, Interval last, Interval curt) {
        if (last == null) {
            return curt;
        }

        // No overlap
        if (last.end < curt.start) {
            results.add(last);
            return curt;
        }

        last.end = Math.max(last.end, curt.end);
        return last;
    }
}
