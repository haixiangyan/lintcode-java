public class LC62 {
    public int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }

            // Make sure that the middle element is on the second quadrant
            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    // Classic binary search
                    end = mid;
                }
                else {
                    // Target is on the forth quadrant
                    start = mid;
                }
            }
            // Otherwise the middle element is on the forth quadrant
            else {
                if (A[mid] <= target && target <= A[end]) {
                    // Classic binary search
                    start = mid;
                }
                else {
                    end = mid;
                }
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
        int[] A = {4, 5, 1, 2, 3};
        int target = 2;

        LC62 lc62 = new LC62();
        System.out.println(lc62.search(A, target));
    }
}
