/*
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.
Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
 */
public class LC447 {
    static class ArrayReader {
        public static int get(int index) {
            return 0;
        }
    }

    public int searchBigSortedArray(ArrayReader reader, int target) {
        int upperBound = findUpperBound(reader, target);

        int start = 0, end = upperBound;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }

        return -1;
    }

    private int findUpperBound(ArrayReader reader, int target) {
        int index = 1;
        while (reader.get(index - 1) < target) {
            index = index * 2;
        }

        return index;
    }
}
