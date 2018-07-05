public class LC61 {
    public int[] searchRange(int[] A, int target) {
        int[] pairs = {-1, -1};

        if (A.length == 0) {
            return pairs;
        }

        int firstIndex = binaryFirstSearch(A, target);

        if (firstIndex == -1) {
            return pairs;
        }

        int count = 0;
        for (int i = firstIndex ; i < A.length ; i++) {
            if (A[i] == target && i != firstIndex) {
                count ++;
            }
        }

        pairs[0] = firstIndex;
        pairs[1] = firstIndex + count;

        return pairs;
    }

    private int binaryFirstSearch(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = {7, 7, 7, 7};
        int target = 7;

        LC61 lc61 = new LC61();

        int[] pairs = lc61.searchRange(A, target);

        for (Integer i : pairs) {
            System.out.println(i);
        }
    }
}
