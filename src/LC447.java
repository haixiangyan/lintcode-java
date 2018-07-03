/*
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.
Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
 */
public class LC447 {
    public int searchBigSortedArray(int[] reader, int target) {
        int bound = findBound(reader, target);

        return binarySeaerch(reader, bound, target);
    }

    private int findBound(int[] reader, int target) {
        int count = 0;
        int num = 0;

        while ((num = reader[count]) != 2147483647) {
            if (num >= target) {
                return count;
            }

            count = count * 2;
        }
        return -1;
    }

    private int binarySeaerch(int[] reader, int bound, int target) {
        if (bound == -1) {
            return -1;
        }

        int start = 0;
        int end = bound;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (reader[mid] == target) {
                return mid;
            }
            else if (reader[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        if (reader[end] == target) {
            return end;
        }
        if (reader[start] == target) {
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        LC447 lc447 = new LC447();

        int[] reader = {1,3,6,9,21, 2147483647};
        int target = 9;

        System.out.println(lc447.searchBigSortedArray(reader, target));
    }
}
